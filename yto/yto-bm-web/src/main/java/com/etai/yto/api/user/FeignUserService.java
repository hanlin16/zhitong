package com.etai.yto.api.user;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.UserService;

@FeignClient("${service.application.name}")
public interface FeignUserService extends UserService{
	
}
