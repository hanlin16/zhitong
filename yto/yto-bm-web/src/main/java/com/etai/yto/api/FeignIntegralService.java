package com.etai.yto.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("${service.application.name}")
public interface FeignIntegralService extends IntegralService{
	
}
