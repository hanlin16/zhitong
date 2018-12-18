package com.etai.yto.api.province;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.ProvinceService;

@FeignClient("${service.application.name}")
public interface FeginProvinceService extends  ProvinceService{

}
