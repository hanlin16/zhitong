package com.etai.yto.page.device;

import java.io.Serializable;

public class DeviceManage implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String providerCode; //供应商编码
	
	private String providerName; //供应商名称
	
	private String deviceCode; //设备标识
	
	private String status;
	
	private String loCompany; //物流公司
	
	private String loOrderNo; //物流单号
	
	private String partyPhoneNo; //当事人手机号
	
	private String licenseNo;   //绑定车牌
	
	private String bindTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoCompany() {
		return loCompany;
	}

	public void setLoCompany(String loCompany) {
		this.loCompany = loCompany;
	}

	public String getLoOrderNo() {
		return loOrderNo;
	}

	public void setLoOrderNo(String loOrderNo) {
		this.loOrderNo = loOrderNo;
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

	public String getBindTime() {
		return bindTime;
	}

	public void setBindTime(String bindTime) {
		this.bindTime = bindTime;
	}
	
}
