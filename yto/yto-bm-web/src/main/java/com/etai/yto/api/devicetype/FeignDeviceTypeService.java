package com.etai.yto.api.devicetype;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.DeviceTypeService;

@FeignClient("${service.application.name}")
public interface FeignDeviceTypeService extends DeviceTypeService {

	
}
