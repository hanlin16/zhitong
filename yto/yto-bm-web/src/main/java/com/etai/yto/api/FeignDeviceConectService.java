package com.etai.yto.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.DeviceConectService;

@FeignClient("${service.application.name}")
public interface FeignDeviceConectService extends DeviceConectService{

}