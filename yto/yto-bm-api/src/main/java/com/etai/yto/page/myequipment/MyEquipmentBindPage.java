package com.etai.yto.page.myequipment;

import java.io.Serializable;

public class MyEquipmentBindPage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String deviceApplyId;
	
	private String licenseNo;
	
	private String deviceCode;
	
	private String receiver;
	
	private String email;
	
	private String phoneNo;
	
	private String identifyCode;
	

	public String getDeviceApplyId() {
		return deviceApplyId;
	}

	public void setDeviceApplyId(String deviceApplyId) {
		this.deviceApplyId = deviceApplyId;
	}

	@Override
	public String toString() {
		return "MyEquipmentBindPage [deviceApplyId=" + deviceApplyId + ", licenseNo=" + licenseNo + ", deviceCode="
				+ deviceCode + ", receiver=" + receiver + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", identifyCode=" + identifyCode + "]";
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getIdentifyCode() {
		return identifyCode;
	}

	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}	
}
