package com.etai.yto.page.device;

import java.io.Serializable;

/**
 * 绑定页面实体
 */
public class BindDeviceInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String bizId;
	
	private String deviceId;
	
	private String applicantName;
	
	private String applicantMobile;
	
	private String licenseNo;
	
	private String addresseeDetails;
	
	private String deviceNo;
	
	private String logisticsCompany;
	
	private String logisticsNo;
	
	private String relationStatus;
	
	public String getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantMobile() {
		return applicantMobile;
	}

	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getAddresseeDetails() {
		return addresseeDetails;
	}

	public void setAddresseeDetails(String addresseeDetails) {
		this.addresseeDetails = addresseeDetails;
	}

}
