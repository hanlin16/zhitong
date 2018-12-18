package com.etai.yto.page.device;

import java.io.Serializable;

public class DeviceApplyModel implements Serializable{

	private static final long serialVersionUID = 5954599076944529576L;
	
	private Integer applyId;
	private String receiver;
	private String applyType;
	private String channelCode;
	private String channelName;
	private String bizNo;
	private Integer linkStatus;
	private String bindStatus; //绑定状态
	private String actionCode;
	
	
	private String applyTime;
	private String address;
	private String receiverPhoneNo;
	
	private String deviceCode;
	
	private String deviceId; //设备表id
	
	private  String orderNo;
	
	private String companyName;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getBindStatus() {
		return bindStatus;
	}
	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getBizNo() {
		return bizNo;
	}
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public Integer getLinkStatus() {
		return linkStatus;
	}
	public void setLinkStatus(Integer linkStatus) {
		this.linkStatus = linkStatus;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReceiverPhoneNo() {
		return receiverPhoneNo;
	}
	public void setReceiverPhoneNo(String receiverPhoneNo) {
		this.receiverPhoneNo = receiverPhoneNo;
	}
	
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "DeviceApplyModel [applyId=" + applyId + ", receiver=" + receiver + ", applyType=" + applyType
				+ ", channelCode=" + channelCode + ", bizNo=" + bizNo + ", linkStatus=" + linkStatus + ", actionCode="
				+ actionCode + ", applyTime=" + applyTime + ", address=" + address + ", receiverPhoneNo="
				+ receiverPhoneNo + ", deviceCode=" + deviceCode + ", orderNo=" + orderNo
				+ ", companyName=" + companyName + "]";
	}
}
