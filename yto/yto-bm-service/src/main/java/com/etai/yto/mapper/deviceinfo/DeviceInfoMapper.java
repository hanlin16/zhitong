package com.etai.yto.mapper.deviceinfo;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.device.DeviceInfo;

public interface DeviceInfoMapper {

	
	@SelectProvider(method="queryDeviceInfo", type=DeviceInfoProvider.class)
	DeviceInfo queryDeviceInfo(@Param("deviceCode")String deviceCode,@Param("status") int status);

	@InsertProvider(method="insertDeviceInfo", type=DeviceInfoProvider.class)
	void insertDeviceInfo(DeviceInfo deviceInfo);

	
}
