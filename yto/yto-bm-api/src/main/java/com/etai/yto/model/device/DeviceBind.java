package com.etai.yto.model.device;

import java.io.Serializable;
import java.util.Date;

public class DeviceBind implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String partyCode; //当事人编码
	
	private String partyPhoneNo;
	
	private String deviceCode;
	
	private String licenseNo;
	
	private String bindStatus;
	
	private Date bindTime;
	
	private Date unbindTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	public String getPartyPhoneNo() {
		return partyPhoneNo;
	}

	public void setPartyPhoneNo(String partyPhoneNo) {
		this.partyPhoneNo = partyPhoneNo;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}

	public Date getBindTime() {
		return bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}

	public Date getUnbindTime() {
		return unbindTime;
	}

	public void setUnbindTime(Date unbindTime) {
		this.unbindTime = unbindTime;
	}
	
}
