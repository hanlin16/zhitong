package com.etai.yto.manager.devicetype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.devicetype.DeviceTypeMapper;
import com.etai.yto.model.device.DeviceType;

@Component
public class DeviceTypeManager {
	
	@Autowired
	DeviceTypeMapper deviceTypeMapper;
	
	public List<DeviceType> getDeviceTypeList(){
		List<DeviceType> deviceTypeList = deviceTypeMapper.getDeviceTypeList();
		return deviceTypeList;
	}
}
