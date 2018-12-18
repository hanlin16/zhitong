package com.etai.okd.api.myEquipment;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.myEquipment.MyEquipmentService;

@FeignClient("${service.application.name}")
public interface OkdMyEquipmentService extends MyEquipmentService{
	
}
