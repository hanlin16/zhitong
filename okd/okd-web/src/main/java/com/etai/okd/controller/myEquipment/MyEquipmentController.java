package com.etai.okd.controller.myEquipment;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etai.okd.api.myEquipment.OkdMyEquipmentService;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.myequipment.MyEquipmentBindPage;

@Controller
@RequestMapping(value="/myEquipment")
public class MyEquipmentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OkdMyEquipmentService myEquipmentService;
	
	@RequestMapping(value="/getUserInfoByDeviceCode")
	@ResponseBody
	public RemoteResult<DeviceApply> getUserInfoByDeviceCode(String deviceCode, HttpSession session) {
		RemoteResult<DeviceApply> result = new RemoteResult<>();
		result = myEquipmentService.getUserInfoByDeviceCode(deviceCode);
		DeviceApply data = result.getData();
		if(data!=null) {
			String receiverPhoneNo = data.getReceiverPhoneNo();
			session.setAttribute("receiverPhoneNo", receiverPhoneNo);
		}else {
			result.setSuccess(false);
			result.setErrorMsg("设备Id不存在");
		}
		return result;
	}
	
	@RequestMapping(value="/bindDeviceUser")
	@ResponseBody
	public RemoteResult<String> bindDeviceUser(MyEquipmentBindPage myEquipmentBind, HttpSession session) {
		String receiverPhoneNo = (String) session.getAttribute("receiverPhoneNo");
		String phoneNo = myEquipmentBind.getPhoneNo();
		RemoteResult<String> remoteResult = new RemoteResult<>();
		String identifyCode = myEquipmentBind.getIdentifyCode();
		if(phoneNo!=null && !phoneNo.equals(receiverPhoneNo)) {
			if(StringUtils.isNotBlank(identifyCode)) {
				String smsCode = (String) session.getAttribute("smsCode");
				if(identifyCode.equals(smsCode)) {
					remoteResult = myEquipmentService.bindDeviceUser(myEquipmentBind);
					return remoteResult;
				}
				remoteResult.setErrorMsg("验证码错误！");
				remoteResult.setSuccess(false);
				return remoteResult;
				
			}else {
				remoteResult.setErrorMsg("验证码不能为空！");
				remoteResult.setSuccess(false);
				return remoteResult;
			}			
		}
		remoteResult = myEquipmentService.bindDeviceUser(myEquipmentBind);
		return remoteResult;
	}
}
