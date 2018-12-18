package com.etai.yto.controller.devicetype;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.devicetype.FeignDeviceTypeService;
import com.etai.yto.model.device.DeviceType;
import com.etai.yto.page.RemoteResult;

@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {

	@Autowired
	FeignDeviceTypeService deviceTypeService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 设备类型查询功能
	 */
	@PostMapping("/queryDeviceTypeList")
	public RemoteResult<List<DeviceType>> queryDeviceTypeList() {
		RemoteResult<List<DeviceType>> remoteResult = new RemoteResult<>();
		try {
			remoteResult = deviceTypeService.getDeviceTypeList();
			return remoteResult;
		} catch (Exception e) {
			logger.error("设备类型查询功能报错:",e);
			remoteResult.setSuccess(false);
			remoteResult.setErrorMsg("设备类型查询功能报错！");
			return remoteResult;
		}
	}	
}
