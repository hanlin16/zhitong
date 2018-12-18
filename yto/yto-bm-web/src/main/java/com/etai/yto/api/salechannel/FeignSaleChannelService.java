package com.etai.yto.api.salechannel;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.SaleChannelService;

@FeignClient("${service.application.name}")
public interface FeignSaleChannelService extends SaleChannelService{
	
}
