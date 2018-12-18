package com.etai.yto.service.impl.myequipment;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.myEquipment.MyEquipmentService;
import com.etai.yto.manager.deviceapply.DeviceApplyManager;
import com.etai.yto.manager.devicebind.DeviceBindManager;
import com.etai.yto.manager.partyinfo.PartyInfoManager;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceBind;
import com.etai.yto.model.partyinfo.PartyInfo;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.myequipment.MyEquipmentBindPage;

@RestController
public class MyEquipmentServiceImpl implements MyEquipmentService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DeviceBindManager deviceBindManager;
	
	@Autowired
	DeviceApplyManager deviceApplyManager;
	
	@Autowired
	PartyInfoManager partyInfoManager;
	
	@Override
	public RemoteResult<DeviceApply> getUserInfoByDeviceCode(String deviceCode) {
		RemoteResult<DeviceApply> result = new RemoteResult<>();
		try {
			DeviceApply deviceApply = deviceApplyManager.getDeviceApplyByDeviceCode(deviceCode);
			result.setData(deviceApply);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error("根据设备编码获取用户信息出错", e);
			result.setErrorMsg("根据设备编码获取用户信息出错");
			result.setSuccess(false);
			return result;
		}
	}

	@Override
	public RemoteResult<String> bindDeviceUser(@RequestBody MyEquipmentBindPage myEquipmentBind) {
		RemoteResult<String> result = new RemoteResult<>();
		try {
			String deviceCode = myEquipmentBind.getDeviceCode();
			// 绑定提交的时候， 设备申领必须处于已关联状态
			DeviceApply deviceApply = deviceApplyManager.getDeviceApplyByDeviceCode(deviceCode);
			if(deviceApply!=null ) {
				String linkStatus = deviceApply.getLinkStatus();
				//1-待关联;2-关联中;3-已关联;4-拒关联
				if(!"3".equals(linkStatus)) {
					result.setErrorMsg("你的设备目前不允许绑定！");
					result.setSuccess(false);
					return result;
				}
			}
			// 已经绑定的设备不能重复绑定
			DeviceBind deviceBindedDb = deviceBindManager.getDeviceBindedByDeviceCode(deviceCode);
			if(deviceBindedDb!=null) {
				//1-待绑定;2-已绑定;3-已解绑
				String bindStatus = deviceBindedDb.getBindStatus();
				if("2".equals(bindStatus)) {
					result.setErrorMsg("无法绑定，设备已处于绑定状态，请先解绑");
					result.setSuccess(false);
					return result;
				}
			}
			//添加当事人记录
			PartyInfo partyInfoDb = partyInfoManager.getPartyInfoByPhoneNo(myEquipmentBind.getPhoneNo());
			PartyInfo partyInfo = new PartyInfo();
			partyInfo.setCreateTime(new Date());
			partyInfo.setEmail(myEquipmentBind.getEmail());
			partyInfo.setName(myEquipmentBind.getReceiver());
			partyInfo.setPhoneNo(myEquipmentBind.getPhoneNo());
			String code = "";
			if(partyInfoDb!=null) {
				code = partyInfoDb.getCode();
				//partyInfoManager.updatePartyInfo(partyInfo);
			}else {
				Integer maxCode = partyInfoManager.getMaxPartyInfoCode();
				if(maxCode==null) {
					maxCode = 10001;
				}
				code = String.valueOf(maxCode+1);
				partyInfo.setCode(code);
				partyInfoManager.insertPartyInfo(partyInfo);
			}
			//添加t_device_bind记录
			String licenseNo = myEquipmentBind.getLicenseNo();
			DeviceBind deviceBindDb = deviceBindManager.getDeviceBindByDeviceCode(deviceCode, licenseNo);
			if(deviceBindDb==null) {
				DeviceBind deviceBind = new DeviceBind();
				deviceBind.setBindTime(new Date());
				deviceBind.setBindStatus("2");
				deviceBind.setDeviceCode(myEquipmentBind.getDeviceCode());
				deviceBind.setLicenseNo(myEquipmentBind.getLicenseNo());
				deviceBind.setPartyCode(code);
				deviceBind.setPartyPhoneNo(myEquipmentBind.getPhoneNo());
				deviceBindManager.insertDeviceBind(deviceBind);
			}else {
				//系统校验并保障一个设备只能绑定一个车牌，如果设备要绑定新的车牌，则必须对原绑定的车牌进行解绑；
				deviceBindDb.setBindStatus("2");
				deviceBindDb.setPartyCode(code);
				deviceBindDb.setPartyPhoneNo(myEquipmentBind.getPhoneNo());
				deviceBindDb.setBindTime(new Date());
				deviceBindManager.updateDeviceBind(deviceBindDb);
			}
			result.setErrorMsg("当前设备绑定成功");
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error("设备绑定出错",e);
			result.setErrorMsg("设备绑定出错");
			result.setSuccess(false);
			return result;
		}
	}

}
