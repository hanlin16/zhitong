package com.etai.yto.page.device;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DeviceData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bizId;
	
	private String applicantName;
	
	private String licenseNo;
	
	private String biPolicyNo;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date payTime;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date biStartDate;
	
	private BigDecimal sumPremium;
	
	private BigDecimal biPremium;
	
	private BigDecimal ciPremium;

	private Integer bindStatus;
	
	private Integer relationStatus;

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
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

	public String getBiPolicyNo() {
		return biPolicyNo;
	}

	public void setBiPolicyNo(String biPolicyNo) {
		this.biPolicyNo = biPolicyNo;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getBiStartDate() {
		return biStartDate;
	}

	public void setBiStartDate(Date biStartDate) {
		this.biStartDate = biStartDate;
	}

	public BigDecimal getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(BigDecimal sumPremium) {
		this.sumPremium = sumPremium;
	}

	public BigDecimal getBiPremium() {
		return biPremium;
	}

	public void setBiPremium(BigDecimal biPremium) {
		this.biPremium = biPremium;
	}

	public BigDecimal getCiPremium() {
		return ciPremium;
	}

	public void setCiPremium(BigDecimal ciPremium) {
		this.ciPremium = ciPremium;
	}

	public Integer getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(Integer bindStatus) {
		this.bindStatus = bindStatus;
	}

	public Integer getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(Integer relationStatus) {
		this.relationStatus = relationStatus;
	}

	@Override
	public String toString() {
		return "DeviceData [applicantName=" + applicantName + ", licenseNo=" + licenseNo + ", biPolicyNo=" + biPolicyNo
				+ ", payTime=" + payTime + ", biStartDate=" + biStartDate + ", sumPremium=" + sumPremium
				+ ", biPremium=" + biPremium + ", ciPremium=" + ciPremium + ", bindStatus=" + bindStatus
				+ ", relationStatus=" + relationStatus + "]";
	}
	
}
