package com.etai.yto.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.TestService;

@FeignClient("${service.application.name}")
public interface FeignTestService extends TestService{
	

}
