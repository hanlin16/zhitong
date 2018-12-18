package com.etai.yto.api.open;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.WriteBackService;

@FeignClient("${service.application.name}")
public interface FeignWriteBackService extends WriteBackService{

	
}
