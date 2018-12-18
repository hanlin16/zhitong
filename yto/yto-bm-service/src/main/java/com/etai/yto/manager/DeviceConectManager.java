package com.etai.yto.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.deviceapply.DeviceApplyMapper;
import com.etai.yto.mapper.deviceinfo.DeviceInfoMapper;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceInfo;
import com.etai.yto.page.device.DeviceApplyModel;
import com.etai.yto.page.device.DeviceApplyPage;

@Component
public class DeviceConectManager {
	
	@Autowired
	DeviceApplyMapper deviceApplyMapper;
	
	@Autowired
	DeviceInfoMapper deviceInfoMapper;

	public int queryDevicesCountPage(DeviceApplyPage page) {
		return deviceApplyMapper.queryDevicesCountPage(page);
	}

	public List<DeviceApplyModel> queryDevicesListPage(DeviceApplyPage page) {
		return deviceApplyMapper.queryDevicesListPage(page);
	}

	public DeviceApplyModel getRalationDetailInfo(String applyId) {
		return deviceApplyMapper.getRalationDetailInfo(applyId);
	}

	public void updateLinkStatus(DeviceApply device) {
		deviceApplyMapper.updateLinkStatus(device);
	}

	public DeviceInfo queryDeviceInfo(String deviceCode, int status) {
		return deviceInfoMapper.queryDeviceInfo(deviceCode, status);
	}
}
