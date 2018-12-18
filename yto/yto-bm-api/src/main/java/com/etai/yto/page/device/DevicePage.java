package com.etai.yto.page.device;

import java.io.Serializable;

import com.etai.yto.page.BasePage;

public class DevicePage extends BasePage implements Serializable{


	private static final long serialVersionUID = -8653426100636558562L;

	private String applicantName;
	
	private String licenseNo;
	
	private String startDate;
	
	private String endDate;
	
	private String relationStatus;
	
	private String bindStatus;
	
	private String limit;

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}

	public String getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}

	@Override
	public String toString() {
		return "DevicePage [applicantName=" + applicantName + ", licenseNo=" + licenseNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", relationStatus=" + relationStatus + ", bindStatus=" + bindStatus + "]";
	}
	
}
