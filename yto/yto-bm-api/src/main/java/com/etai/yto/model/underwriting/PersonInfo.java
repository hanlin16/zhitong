package com.etai.yto.model.underwriting;

import java.io.Serializable;
/**
 * 人员信息节点
 * @author liushengli
 * @date 2018年7月17日
 */
public class PersonInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5236211237285943994L;
	
	private String ownerName;
	
	private String ownerIdNo;
	
	private String ownerMobile;
	
	private String applicantName;
	
	private String applicantIdNo;
	
	private String applicantMobile;
	
	private String insuredName;
	
	private String insuredIdNo;
	
	private String insuredMobile;
	
	private String insuredAddress;
	
	private String addresseeName;
	
	private String addresseeMobile;
	
	private String addresseeDetails;
	
	private String policyEmail;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerIdNo() {
		return ownerIdNo;
	}

	public void setOwnerIdNo(String ownerIdNo) {
		this.ownerIdNo = ownerIdNo;
	}

	public String getOwnerMobile() {
		return ownerMobile;
	}

	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantIdNo() {
		return applicantIdNo;
	}

	public void setApplicantIdNo(String applicantIdNo) {
		this.applicantIdNo = applicantIdNo;
	}

	public String getApplicantMobile() {
		return applicantMobile;
	}

	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getInsuredIdNo() {
		return insuredIdNo;
	}

	public void setInsuredIdNo(String insuredIdNo) {
		this.insuredIdNo = insuredIdNo;
	}

	public String getInsuredMobile() {
		return insuredMobile;
	}

	public void setInsuredMobile(String insuredMobile) {
		this.insuredMobile = insuredMobile;
	}

	public String getInsuredAddress() {
		return insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public String getAddresseeName() {
		return addresseeName;
	}

	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}

	public String getAddresseeMobile() {
		return addresseeMobile;
	}

	public void setAddresseeMobile(String addresseeMobile) {
		this.addresseeMobile = addresseeMobile;
	}

	public String getAddresseeDetails() {
		return addresseeDetails;
	}

	public void setAddresseeDetails(String addresseeDetails) {
		this.addresseeDetails = addresseeDetails;
	}

	public String getPolicyEmail() {
		return policyEmail;
	}

	public void setPolicyEmail(String policyEmail) {
		this.policyEmail = policyEmail;
	}

	@Override
	public String toString() {
		return "PersonInfo [ownerName=" + ownerName + ", ownerIdNo=" + ownerIdNo + ", ownerMobile=" + ownerMobile
				+ ", applicantName=" + applicantName + ", applicantIdNo=" + applicantIdNo + ", applicantMobile="
				+ applicantMobile + ", insuredName=" + insuredName + ", insuredIdNo=" + insuredIdNo + ", insuredMobile="
				+ insuredMobile + ", insuredAddress=" + insuredAddress + ", addresseeName=" + addresseeName
				+ ", addresseeMobile=" + addresseeMobile + ", addresseeDetails=" + addresseeDetails + ", policyEmail="
				+ policyEmail + "]";
	}
	/* "personInfo": {
        "ownerName": "测试",
        "ownerIdNo": "111111111111111111",
        "ownerMobile": "13333333333",
        "applicantName": "测试",
        "applicantIdNo": "111111111111111111",
        "applicantMobile": "13333333333",
        "insuredName": "测试",
        "insuredIdNo": "111111111111111111",
        "insuredMobile": "13333333333",
        "insuredAddress": null,
        "addresseeName": "测试",
        "addresseeMobile": "18910289305",
        "addresseeDetails": "北京市 北京市 东城",
        "policyEmail": "76543567@126.com"
    },*/

}
