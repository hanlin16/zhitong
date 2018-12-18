package com.etai.yto.page.policy;

import java.io.Serializable;
import java.math.BigDecimal;

public class PolicyInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String ztBizId; 
	
	private String biPolicyNo;  //商业保单号
	
	private String licenseNo; //车牌号
	
	private BigDecimal sumPremium; //总保费
	
	private String biStartDate;
	
	private String biEndDate;
	
	private String insuredName; //投保人
	
	public String getZtBizId() {
		return ztBizId;
	}

	public void setZtBizId(String ztBizId) {
		this.ztBizId = ztBizId;
	}

	public String getBiPolicyNo() {
		return biPolicyNo;
	}

	public void setBiPolicyNo(String biPolicyNo) {
		this.biPolicyNo = biPolicyNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public BigDecimal getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(BigDecimal sumPremium) {
		this.sumPremium = sumPremium;
	}

	public String getBiStartDate() {
		return biStartDate;
	}

	public void setBiStartDate(String biStartDate) {
		this.biStartDate = biStartDate;
	}

	public String getBiEndDate() {
		return biEndDate;
	}

	public void setBiEndDate(String biEndDate) {
		this.biEndDate = biEndDate;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
}
