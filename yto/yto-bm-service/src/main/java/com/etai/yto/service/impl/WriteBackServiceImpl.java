package com.etai.yto.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.etai.yto.api.WriteBackService;
import com.etai.yto.manager.open.WritebackManager;
import com.etai.yto.manager.preinfo.PreInfoManager;
import com.etai.yto.manager.saleaction.SaleActionManager;
import com.etai.yto.manager.syscode.EightCodeManager;
import com.etai.yto.model.preinfo.PreInfoModel;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.model.syscode.EightCode;
import com.etai.yto.model.underwriting.Agreements;
import com.etai.yto.model.underwriting.ApplyDeviceInfo;
import com.etai.yto.model.underwriting.ExtraData;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.model.underwriting.PersonInfo;
import com.etai.yto.model.underwriting.Proposals;
import com.etai.yto.model.underwriting.VehicleInfo;
import com.etai.yto.model.underwriting.WritingData;
import com.etai.yto.model.underwriting.WritingReceive;
import com.etai.yto.model.underwriting.WritingSend;
import com.etai.yto.model.utils.UbiConstant;
@RestController
public class WriteBackServiceImpl implements WriteBackService  {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WritebackManager writebackManager;
	
	@Autowired
	private EightCodeManager eightCodeManager;
	
	@Autowired
	private SaleActionManager saleActionManager;
	
	@Autowired
	PreInfoManager preInfoManager;
	/**
	 * 易通承保回写
	 * @return
	 * 2018年7月18日
	 * WritingSend
	 */
	@Override
	public WritingSend saveUnderwriting(@RequestBody String paramstr) {
		WritingSend sendResult = new WritingSend();
		JSONObject json = new JSONObject();
		try {
			json = JSON.parseObject(paramstr);
		} catch (Exception e) {
			sendResult.setState(UbiConstant.FAIL_CODE);
			sendResult.setMessage(UbiConstant.JSON_ERROR);
			logger.error("易通承保回写:",e);
			return sendResult;
		}
		try {
			WritingReceive writingReceive = JSON.toJavaObject(json, WritingReceive.class);
			if (writingReceive!=null) {
				WritingData data = writingReceive.getData();
				int bizNo = Integer.parseInt(data.getBizId());
				writebackManager.deleteProposalByNo(bizNo);
				writebackManager.deletePersonByNo(bizNo);
				writebackManager.deleteCarinfoByNo(bizNo);
				writebackManager.deleteKindByNo(bizNo);
				writebackManager.deleteAgreementByNo(bizNo);
				writebackManager.insertPerson(data.getPersonInfo(), bizNo);
				writebackManager.insertCarinfo(data.getVehicleInfo(), bizNo);
				
				List<Kinds> kinds = data.getKinds();
				List<Proposals> proposals = data.getProposals();
				List<Agreements> agreements = data.getAgreements();
				if (kinds != null && !kinds.isEmpty()) {
					for (Kinds kind : kinds) {
						writebackManager.insertKind(kind, bizNo);
					}
				}
				if (agreements != null && !agreements.isEmpty()) {
					for (Agreements agreement : agreements) {
						writebackManager.insertAgreements(agreement, bizNo);
					}
				}
				ExtraData extraData = new ExtraData();
				extraData.setAcceptTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				if (proposals != null && !proposals.isEmpty()) {
					for (Proposals proposal : proposals) {
						String riskCode= proposal.getRiskCode();//0528-商业险；0507-交强险
						if ("0528".equals(riskCode)) {
							extraData.setBiProposalNo(proposal.getProposalNo());
							extraData.setBiPolicyNo(proposal.getPolicyNo());
						}else if ("0507".equals(riskCode)) {
							extraData.setCiProposalNo(proposal.getProposalNo());
							extraData.setCiPolicyNo(proposal.getPolicyNo());
						}
					}
				}
				writebackManager.insertProposal(data, extraData);
				Integer total = writebackManager.queryDeviceByPhone(data.getPersonInfo().getOwnerMobile(),data.getVehicleInfo().getLicenseNo());
				//查询设备申领时间
				ApplyDeviceInfo deviceInfo = writebackManager.queryAppDeviceInfoByLicenceNo(data.getVehicleInfo().getLicenseNo());
				String applyTime = deviceInfo.getApplyTime();
				String applyType = deviceInfo.getApplyType();
				
				if (total==null || total==0) {//A类业务生成设备申领信息
					saveEquipmentApply(data.getPersonInfo(),data.getVehicleInfo(),writingReceive);//生成设备申领信息
				}else if ("B".equals(applyType) && !isUsed(applyTime)) {//b类业务回写生成保单号如果申领时间超过180天,生成新的申领信息
					saveEquipmentApply(data.getPersonInfo(),data.getVehicleInfo(),writingReceive);//生成设备申领信息
					
				}
			}
			sendResult.setState(UbiConstant.SUCCESS_CODE);
		} catch (Exception e) {
			sendResult.setState(UbiConstant.FAIL_CODE);
			sendResult.setMessage(UbiConstant.SAVE_ERROR);
			logger.error("易通承保回写:",e);
		}
		return sendResult;
	}
	/**
	 * 判断是否在180天范围内
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	private Boolean isUsed(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance(); 
		Date parse = format.parse(date);
		Date now = new Date();
		calendar.setTime(parse);
		calendar.add(Calendar.DAY_OF_MONTH, 180);
		
		return now.getTime()<calendar.getTimeInMillis();
		
	}
	/**
	 * 生成设备申领信息
	 * @param personInfo
	 * 2018年9月3日
	 * void
	 * @param vehicleInfo 
	 */
	private  void saveEquipmentApply(PersonInfo personInfo, VehicleInfo vehicleInfo,WritingReceive writingReceive){
		String uuid =eightCodeManager();
		ApplyDeviceInfo applyDeviceInfo = new ApplyDeviceInfo();
		applyDeviceInfo.setBizNo(uuid);
		applyDeviceInfo.setAddresseeName(personInfo.getAddresseeName());
		applyDeviceInfo.setAddresseeMobile(personInfo.getAddresseeMobile());
		String provinceName = writingReceive.getData().getProvinceName();
		String cityName = writingReceive.getData().getCityName();
		String address = provinceName+" "+cityName+" "+personInfo.getAddresseeDetails();
		applyDeviceInfo.setAddresseeDetails(address);
		applyDeviceInfo.setApplyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		applyDeviceInfo.setApplyType("A");
		applyDeviceInfo.setLinkStatus(1);
		
		String licenseNo = vehicleInfo.getLicenseNo();
		PreInfoModel preInfoModel = preInfoManager.queryByLicenceNo(licenseNo);
		
		SaleAction saleAction = saleActionManager.getSaleActionByCode(preInfoModel.getActionCode());
		applyDeviceInfo.setChannelCode(saleAction.getChannelCode());
		applyDeviceInfo.setActionCode(preInfoModel.getActionCode());
		writebackManager.saveEquipmentApply(applyDeviceInfo);
	}
	/**
	 * 生成8位随机码
	 * @return
	 * 2018年9月13日
	 * String
	 */
	private String eightCodeManager(){
		try {
			EightCode eightCode = eightCodeManager.queryEightCode();
			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			if (eightCode!=null) {
				return eightCode.getCode();
			}			
			for (int i = 0; i < 100; i++) {
				String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
				uuid = uuid.substring(0, 8);
				EightCode eightCodeTemp = new EightCode();
				eightCodeTemp.setCode(uuid);
				eightCodeTemp.setStatus("0");
				eightCodeTemp.setBatchNo("20181");
				eightCodeTemp.setCreateTime(dateStr);
				try {
					eightCodeManager.insertEightCode(eightCodeTemp);
				} catch (DuplicateKeyException e) {
					logger.error("生成编码重复： "+eightCodeTemp.getCode(), e);
				}
			}
			eightCode = eightCodeManager.queryEightCode();
			if (eightCode!=null) {
				eightCode.setStatus("1");
				eightCode.setUseTime(dateStr);
				eightCodeManager.UpdateEightCode(eightCode);
				return eightCode.getCode();
			}
			return "";
		} catch (Exception e) {
			logger.error("生成8位随机码：",e);
			return "";
		}
	}
}
