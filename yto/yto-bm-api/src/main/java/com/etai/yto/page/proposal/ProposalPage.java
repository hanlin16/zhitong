package com.etai.yto.page.proposal;

import java.io.Serializable;

import com.etai.yto.page.BasePage;

public class ProposalPage extends BasePage  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String biPolicyNo;       //商业险保单号
	private String licenseNo;    //车牌号
	private String applicantName;    //投保人姓名
	private String startTime;    //开始时间
	private String endTime;    //截止时间
	
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
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

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ProposalPage [biPolicyNo=" + biPolicyNo + ", licenseNo=" + licenseNo + ", applicantName="
				+ applicantName + ", startTime=" + startTime + ", endTime=" + endTime + ", limit=" + limit + "]";
	}
	
}
