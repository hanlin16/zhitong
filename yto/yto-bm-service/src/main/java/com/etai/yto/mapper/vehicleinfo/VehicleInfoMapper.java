package com.etai.yto.mapper.vehicleinfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.underwriting.VehicleInfo;

public interface VehicleInfoMapper {

	@SelectProvider(method="getVehicleInfo", type=VehicleInfoProvider.class)
	VehicleInfo getVehicleInfo(@Param("bizId") String bizId);
	
}
