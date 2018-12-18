package com.etai.yto.manager.devicemanage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.etai.yto.mapper.devicemanage.DeviceManageMapper;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceBind;
import com.etai.yto.model.device.DeviceInfo;
import com.etai.yto.page.device.DeviceManage;
import com.etai.yto.page.device.DeviceManagePage;
import com.etai.yto.page.policy.PolicyInfo;

@Component("deviceManageManager")
public class DeviceManageManager {

	@Resource
	private DeviceManageMapper deviceManageMapper;
	
	public List<DeviceManage> queryDeviceManagePage(DeviceManagePage page){
		List<DeviceManage>  list = deviceManageMapper.queryDeviceManagePage(page);
		return list;
	}
	
	/**
	 * 查询设备总条数
	 */
	public int queryDeviceManageCount(DeviceManagePage page) {
		return deviceManageMapper.queryDeviceManageCount(page);
	}

	/**
	 * 根据设备Id获取设备信息
	 */
	public DeviceInfo getDeviceInfoById(Integer deviceManageId) {
		return deviceManageMapper.getDeviceInfoById(deviceManageId);
	}

	public List<DeviceBind> getDeviceBindByCode(String deviceCode) {
		return deviceManageMapper.getDeviceBindByCode(deviceCode);
	}

	public DeviceApply getDeviceApplyById(String deviceApplyId) {
		return deviceManageMapper.getDeviceApplyById(deviceApplyId);
	}

	public List<PolicyInfo> getPolicyInfoByLisenseNo(ArrayList<String> lisenseNoList) {
		return deviceManageMapper.getPolicyInfoByLisenseNo(lisenseNoList);
	}
}
