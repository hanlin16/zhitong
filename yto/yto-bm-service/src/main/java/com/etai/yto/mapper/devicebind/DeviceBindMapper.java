package com.etai.yto.mapper.devicebind;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.etai.yto.model.device.DeviceBind;

public interface DeviceBindMapper {

	
	@SelectProvider(method="getDeviceBindByDeviceCode", type=DeviceBindProvider.class)
	public DeviceBind getDeviceBindByDeviceCode(@Param("deviceCode")String deviceCode, @Param("licenseNo")String licenseNo);

	@Insert(" insert into t_device_bind(PARTY_CODE,PARTY_PHONE_NO," + 
			" DEVICE_CODE,LICENSE_NO,\n" + 
			" BIND_STATUS,BIND_TIME, UNBIND_TIME" + 
			" ) values(#{partyCode}, #{partyPhoneNo}, #{deviceCode}, #{licenseNo},"
			+ " #{bindStatus}, #{bindTime}, #{unbindTime})")
	public void insertDeviceBind(DeviceBind deviceBind);

	@Update(" update t_device_bind set PARTY_CODE=#{partyCode},"
			+ " PARTY_PHONE_NO=#{partyPhoneNo}, BIND_STATUS=#{bindStatus}, BIND_TIME=#{bindTime} where DEVICE_CODE=#{deviceCode} "
			+ " and LICENSE_NO=#{licenseNo} ")
	public void updateDeviceBind(DeviceBind deviceBindDb);

	@SelectProvider(method="getDeviceBindedByDeviceCode", type=DeviceBindProvider.class)
	public DeviceBind getDeviceBindedByDeviceCode(@Param("deviceCode") String deviceCode);
}
