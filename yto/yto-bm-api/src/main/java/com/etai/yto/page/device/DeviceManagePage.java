package com.etai.yto.page.device;

import com.etai.yto.page.BasePage;

public class DeviceManagePage extends BasePage{

	private static final long serialVersionUID = 1L;

	private String deviceCode; //设备编码
	
	private String partyPhoneNo; //当事人手机号
	
	private String licenseNo;   //绑定车牌
	
	private String providerCode;  //供应商
	
	private String bindBegintime;  // 开始绑定时间
	
	private String bindEndtime;  // 结束绑定时间
	
	private Integer limit;
	
	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getPartyPhoneNo() {
		return partyPhoneNo;
	}

	public void setPartyPhoneNo(String partyPhoneNo) {
		this.partyPhoneNo = partyPhoneNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getBindBegintime() {
		return bindBegintime;
	}

	public void setBindBegintime(String bindBegintime) {
		this.bindBegintime = bindBegintime;
	}

	public String getBindEndtime() {
		return bindEndtime;
	}

	public void setBindEndtime(String bindEndtime) {
		this.bindEndtime = bindEndtime;
	}
	
}
