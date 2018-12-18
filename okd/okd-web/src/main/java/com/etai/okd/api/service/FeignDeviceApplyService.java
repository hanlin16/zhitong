package com.etai.okd.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.DeviceApplyService;

@FeignClient("${service.application.name}")
public interface FeignDeviceApplyService extends DeviceApplyService{
	
}
