package com.etai.yto.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.vehicleinfo.VehicleInfoMapper;
import com.etai.yto.model.underwriting.VehicleInfo;

@Component
public class VehicleInfoManager {

	@Autowired
	VehicleInfoMapper vehicleInfoMapper;
	
	public VehicleInfo getVehicleInfo(String bizId) {
		return vehicleInfoMapper.getVehicleInfo(bizId);
	}
}
