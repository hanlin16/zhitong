package com.etai.okd.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.syscode.EightCodeService;

@FeignClient("${service.application.name}")
public interface FeignSYSCodeService extends EightCodeService{
	
}
