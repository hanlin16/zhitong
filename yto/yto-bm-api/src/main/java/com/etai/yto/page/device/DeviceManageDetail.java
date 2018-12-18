package com.etai.yto.page.device;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceBind;
import com.etai.yto.model.device.DeviceInfo;
import com.etai.yto.page.policy.PolicyInfo;

public class DeviceManageDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	private DeviceInfo deviceInfo = new DeviceInfo();
	
	private List<DeviceBind> deviceBindList = new ArrayList<>();
	
	private DeviceApply deviceApply = new DeviceApply();
	
	private List<PolicyInfo> policyList = new ArrayList<>();
	
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public List<DeviceBind> getDeviceBindList() {
		return deviceBindList;
	}

	public void setDeviceBindList(List<DeviceBind> deviceBindList) {
		this.deviceBindList = deviceBindList;
	}

	public DeviceApply getDeviceApply() {
		return deviceApply;
	}

	public void setDeviceApply(DeviceApply deviceApply) {
		this.deviceApply = deviceApply;
	}

	public List<PolicyInfo> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<PolicyInfo> policyList) {
		this.policyList = policyList;
	}
	
}
