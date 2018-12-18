package com.etai.yto.manager.deviceapply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.deviceapply.DeviceApplyMapper;
import com.etai.yto.model.device.DeviceApply;

@Component
public class DeviceApplyManager {

	@Autowired
	DeviceApplyMapper deviceApplyMapper;
	
	public DeviceApply getDeviceApplyByDeviceCode(String deviceCode) {
		return deviceApplyMapper.getDeviceApplyByDeviceCode(deviceCode);
	}
	
public void deviceapplyUpdate(DeviceApply device) {
		
		deviceApplyMapper.deviceapplyUpdate(device);
	}

	/**
	 * 根据业务号查询申领信息
	 */
	public DeviceApply queryDeviceApplyInfoByBizNo(String bizNo) {
		
		return deviceApplyMapper.queryDeviceApplyInfoByBizNo(bizNo);
	}

	/**
	 * 添加设备申领信息
	 */
	public void deviceApplyAdd(DeviceApply device) {
		
		deviceApplyMapper.deviceApplyAdd(device);
	}

	/**
	 * 更具活动编码查询设备申领信息
	 * @param actionCode
	 * @return
	 */
	public List<DeviceApply> getDeviceApplyByActionCode(String actionCode) {
		return deviceApplyMapper.getDeviceApplyByActionCode(actionCode);
	}
	/**
	 * 根据渠道查询设备申领信息
	 * @param channelCode
	 * @return
	 */
	public List<DeviceApply> getDeviceApplyByChannelCode(String channelCode) {
		return deviceApplyMapper.getDeviceApplyByChannelCode(channelCode);
	}
}
