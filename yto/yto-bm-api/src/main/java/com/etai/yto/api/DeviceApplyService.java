package com.etai.yto.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.RemoteResult;

public interface DeviceApplyService {

	@GetMapping("/devcieApply/queryDeviceApplyInfoByBizNo")
	RemoteResult<DeviceApply> queryDeviceApplyInfoByBizNo(@RequestParam("bizNo") String bizNo);

	@PostMapping("/devcieApply/deviceapplyUpdate")
	RemoteResult<DeviceApply> deviceapplyUpdate(DeviceApply device);

	@PostMapping("/devcieApply/deviceApplyAdd")
	RemoteResult<DeviceApply> deviceApplyAdd(DeviceApply device);
	
}
