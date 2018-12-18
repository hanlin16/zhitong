package com.etai.okd.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.PreInfoService;

@FeignClient("${service.application.name}")
public interface FeignPreInfoService extends PreInfoService{
	
}
