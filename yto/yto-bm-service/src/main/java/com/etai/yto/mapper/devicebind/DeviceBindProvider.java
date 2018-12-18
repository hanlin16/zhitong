package com.etai.yto.mapper.devicebind;

import org.apache.ibatis.annotations.Param;

public class DeviceBindProvider {
	
	public String getDeviceBindByDeviceCode(@Param("deviceCode") String deviceCode, @Param("licenseNo")String licenseNo) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT id,party_code, " + 
				" party_phone_no,device_code,license_no, " + 
				" bind_status,bind_time,unbind_time " + 
				" from t_device_bind " + 
				" where device_code=#{deviceCode} and license_no = #{licenseNo} ");
		return sb.toString();
	}
	
	public String getDeviceBindedByDeviceCode(@Param("deviceCode") String deviceCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT id,party_code, " + 
				" party_phone_no,device_code,license_no, " + 
				" bind_status,bind_time,unbind_time " + 
				" from t_device_bind " + 
				" where device_code=#{deviceCode} and bind_status = 2 ");
		return sb.toString();
	}
}
