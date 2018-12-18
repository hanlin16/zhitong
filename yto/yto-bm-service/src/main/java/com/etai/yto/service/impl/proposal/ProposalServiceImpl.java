package com.etai.yto.service.impl.proposal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.ProposalService;
import com.etai.yto.manager.PersonInfoManager;
import com.etai.yto.manager.ProposalManager;
import com.etai.yto.manager.VehicleInfoManager;
import com.etai.yto.model.proposal.ProposalModel;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.model.underwriting.PersonInfo;
import com.etai.yto.model.underwriting.VehicleInfo;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.proposal.ProposalPage;
import com.etai.yto.utils.SendMailUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProposalServiceImpl implements ProposalService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProposalManager proposalManager;
	
	@Autowired
	VehicleInfoManager vehicleInfoManager;
	
	@Autowired
	PersonInfoManager personInfoManager;
	
	@Override
	@HystrixCommand(fallbackMethod = "failMethod")
	public RemoteResult<ProposalModel> getProposalDetail(@RequestParam("bizId")String bizId) {
		RemoteResult<ProposalModel> result = new RemoteResult<ProposalModel>();
		try {
			ProposalModel data = proposalManager.getProposalDetail(bizId);
			List<Kinds> kinds = proposalManager.getKindDetail(bizId);
			PersonInfo personInfo = personInfoManager.getPersionInfo(bizId);
			VehicleInfo vehicleInfo = vehicleInfoManager.getVehicleInfo(bizId);
			data.setKinds(kinds);
			data.setPersonInfo(personInfo);
			data.setVehicleInfo(vehicleInfo);
			result.setData(data);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("保单信息明细数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 熔断返回
	 */
	public RemoteResult<Object> failMethod(){
		RemoteResult<Object> result = new RemoteResult<Object>();
		result.setSuccess(false);
		result.setErrorMsg("调用失败");
		return result;
	}

	@Override
	public RemoteResult<PageResult<ProposalModel>> getProposalList(@RequestBody ProposalPage proposalPage) {
		RemoteResult<PageResult<ProposalModel>> result = new RemoteResult<PageResult<ProposalModel>>();
		PageResult<ProposalModel> pageResult = new PageResult<>();
		try {
			logger.debug("保单信息查询条件:"+proposalPage);
			int count = proposalManager.queryProposalCount(proposalPage);
			
			List<ProposalModel> list = proposalManager.queryProposal(proposalPage);
			logger.debug("保单信息:"+list);
			for (ProposalModel proposalModel : list) {
				String bizId = proposalModel.getBizId();
				PersonInfo personInfo = personInfoManager.getPersionInfo(bizId);
				VehicleInfo vehicleInfo = vehicleInfoManager.getVehicleInfo(bizId);
				proposalModel.setPersonInfo(personInfo);
				proposalModel.setVehicleInfo(vehicleInfo);
			}
			logger.debug("保单信息处理之后:"+list);
			proposalPage.setRowCount(count);
			pageResult.setPage(proposalPage.getPager());
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			
		} catch (Exception e) {
			logger.error("查询数据库保单异常:",e);
			result.setErrorMsg("数据库查询异常!");
		}
		return result;
	}	
	
}
