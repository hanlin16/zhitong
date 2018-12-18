package com.etai.yto.model.underwriting;

import java.io.Serializable;

public class ApplyDeviceInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2425989828098548701L;
	
	private String addresseeName;
	
	private String addresseeMobile;
	
	private String addresseeDetails;
	
	private String bizNo;
	private String channelCode;
	private String actionCode;
	private String applyTime;
	private String applyType;
	private Integer linkStatus;
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
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public Integer getLinkStatus() {
		return linkStatus;
	}
	public void setLinkStatus(Integer linkStatus) {
		this.linkStatus = linkStatus;
	}
	public String getBizNo() {
		return bizNo;
	}
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	@Override
	public String toString() {
		return "ApplyDeviceInfo [addresseeName=" + addresseeName + ", addresseeMobile=" + addresseeMobile
				+ ", addresseeDetails=" + addresseeDetails + ", bizNo=" + bizNo + ", channelCode=" + channelCode
				+ ", actionCode=" + actionCode + ", applyTime=" + applyTime + ", applyType=" + applyType
				+ ", linkStatus=" + linkStatus + "]";
	}
}
