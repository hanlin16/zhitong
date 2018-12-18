package com.etai.yto.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.LoginService;

@FeignClient("${service.application.name}")
public interface FeignLoginService extends LoginService{


}
