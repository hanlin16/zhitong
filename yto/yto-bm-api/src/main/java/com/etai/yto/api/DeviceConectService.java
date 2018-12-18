package com.etai.yto.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.device.BindDeviceInfo;
import com.etai.yto.page.device.DeviceApplyModel;
import com.etai.yto.page.device.DeviceApplyPage;
import com.etai.yto.page.device.RalationDevicePage;

public interface DeviceConectService {

	@PostMapping("/queryDevicesList")
	RemoteResult<PageResult<DeviceApplyModel>> queryDevicesListPage(DeviceApplyPage page);

	@PostMapping("deviceConect/getRelationDeviceInfo")
	RemoteResult<DeviceApplyModel> getRelationDeviceInfo(@RequestParam("applyId") String applyId);

	@PostMapping("/relatingDeviceData")
	RemoteResult<BindDeviceInfo> connectingDevice(RalationDevicePage param);
	
	
	@PostMapping("deviceConect/relationDevice")
	RemoteResult<String> relationDevice(@RequestParam("applyId") String applyId,@RequestParam("deviceCode") String deviceCode,
			@RequestParam("logisticsCompany") String logisticsCompany,@RequestParam("logisticsNo") String logisticsNo);
	
	@PostMapping("deviceConect/unrelationInfo")
	RemoteResult<String> unrelationInfo(@RequestParam("applyId") String applyId);
}
