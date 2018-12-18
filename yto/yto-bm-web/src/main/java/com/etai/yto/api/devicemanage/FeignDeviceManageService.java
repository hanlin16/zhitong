package com.etai.yto.api.devicemanage;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.DeviceManageService;

@FeignClient("${service.application.name}")
public interface FeignDeviceManageService extends DeviceManageService{
	
}
