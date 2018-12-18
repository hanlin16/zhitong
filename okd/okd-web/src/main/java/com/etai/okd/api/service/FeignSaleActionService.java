package com.etai.okd.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.SaleActionService;

@FeignClient("${service.application.name}")
public interface FeignSaleActionService extends SaleActionService{
	
}
