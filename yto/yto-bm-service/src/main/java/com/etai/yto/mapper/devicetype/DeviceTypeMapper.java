package com.etai.yto.mapper.devicetype;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.etai.yto.model.device.DeviceType;

public interface DeviceTypeMapper {

	@Select(" select ID,CODE,NAME,PROVIDER_CODE, " + 
			" AMOUNT,STATUS,CREATE_USER, " + 
			" CREATE_TIME,UPDATE_USER,UPDATE_TIME " + 
			" from t_device_type ")
	public List<DeviceType> getDeviceTypeList();
}
