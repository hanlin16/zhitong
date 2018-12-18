package com.etai.yto.manager.deviceinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.deviceinfo.DeviceInfoMapper;
import com.etai.yto.model.device.DeviceInfo;

@Component
public class DeviceInfoManager {
	
	@Autowired
	DeviceInfoMapper deviceInfoMapper;

	public void insertDeviceInfo(DeviceInfo deviceInfo) {
		deviceInfoMapper.insertDeviceInfo(deviceInfo);
	}

	
}
