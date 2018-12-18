package com.etai.yto.controller.deviceconect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.FeignDeviceConectService;
import com.etai.yto.api.FeignProposalService;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.device.BindDeviceInfo;
import com.etai.yto.page.device.DeviceApplyModel;
import com.etai.yto.page.device.DeviceApplyPage;
import com.etai.yto.page.device.RalationDevicePage;

@RestController
@RequestMapping("deviceConect")
public class DeviceConectController {

	@Autowired(required=false)
	FeignDeviceConectService deviceConectService;
	
	@Autowired(required=false)
	FeignProposalService proposalService;
	
	/**
	 * 关联中设备
	 */
	@PostMapping("/relatingDeviceData")
	public RemoteResult<BindDeviceInfo> relatingDeviceData(RalationDevicePage param, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		param.setOperatorId(user.getId());
		RemoteResult<BindDeviceInfo> remoteResult = deviceConectService.connectingDevice(param);
		return remoteResult;
	}
	
	/**
	 * 申领设备查询功能
	 */
	@PostMapping("/queryDevicesList")
	public PageResult<DeviceApplyModel> queryDevicesList(DeviceApplyPage page) {
		RemoteResult<PageResult<DeviceApplyModel>> remoteResult = deviceConectService.queryDevicesListPage(page);
		if(remoteResult.isSuccess()) {
			PageResult<DeviceApplyModel> data = remoteResult.getData();
			data.setState(true);
			return data;
		}else {
			PageResult<DeviceApplyModel> data = remoteResult.getData();
			data.setState(false);
			data.setErrorMsg(remoteResult.getErrorMsg());
			return data;
		}
	}
	
	/**
	 * 关联
	 */
	@PostMapping("/relationDevice")
	public RemoteResult<String> relationDevice(HttpServletRequest request,HttpServletResponse response){
		RemoteResult<String> result = new RemoteResult<String>();
		String applyId = request.getParameter("applyId");
		String deviceCode = request.getParameter("deviceCode");
		String logisticsCompany = request.getParameter("logisticsCompany");
		String logisticsNo = request.getParameter("logisticsNo");
		result = deviceConectService.relationDevice(applyId, deviceCode,logisticsCompany,logisticsNo);
		return result;
	}
	
	/**
	 * 拒关联
	 */
	@PostMapping("/unrelationDevice")
	public RemoteResult<String> unrelationDevice(HttpServletRequest request,HttpServletResponse response){
		RemoteResult<String> result = new RemoteResult<String>();
		String applyId = request.getParameter("applyId");
		result = deviceConectService.unrelationInfo(applyId);
		return result;
	}
}
