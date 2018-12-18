package com.etai.yto.manager.devicebind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.devicebind.DeviceBindMapper;
import com.etai.yto.model.device.DeviceBind;

@Component
public class DeviceBindManager {

	@Autowired
	DeviceBindMapper deviceBindMapper;
	
	/**
	 * 查找所有的绑定表信息
	 */
	public DeviceBind getDeviceBindByDeviceCode(String deviceCode, String licenseNo) {
		return deviceBindMapper.getDeviceBindByDeviceCode(deviceCode,licenseNo);
	}

	public void insertDeviceBind(DeviceBind deviceBind) {
		deviceBindMapper.insertDeviceBind(deviceBind);
	}

	public void updateDeviceBind(DeviceBind deviceBindDb) {
		deviceBindMapper.updateDeviceBind(deviceBindDb);
	}

	/**
	 * 查找已经绑定的设备
	 */
	public DeviceBind getDeviceBindedByDeviceCode(String deviceCode) {
		return deviceBindMapper.getDeviceBindedByDeviceCode(deviceCode);
	}
}
