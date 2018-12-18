package com.etai.okd.api.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.CityMappingService;

@FeignClient("${service.application.name}")
public interface FeignCityMappingService extends CityMappingService{
	
}
