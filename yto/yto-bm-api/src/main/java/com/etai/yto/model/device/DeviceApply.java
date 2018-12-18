package com.etai.yto.model.device;

import java.io.Serializable;

public class DeviceApply implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id; //主键
	
	private String bizNo; //业务号
	
	private String receiver; //收件人
	
	private String address; //配送地址
	
	private String receiverPhoneNo; //收件人手机号
	
	private String channelCode;  //渠道编码
	
	private String channelName;
	
	private String actionCode; //活动码
	
	private String applyTime; //申领时间
	
	private String applyType;  //申领类型
	
	private String linkStatus; //关联状态
	
	private String payStatus; //支付状态

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBizNo() {
		return bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public String getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(String linkStatus) {
		this.linkStatus = linkStatus;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	@Override
	public String toString() {
		return "DeviceApply [id=" + id + ", bizNo=" + bizNo + ", receiver=" + receiver + ", address=" + address
				+ ", receiverPhoneNo=" + receiverPhoneNo + ", channelCode=" + channelCode + ", actionCode=" + actionCode
				+ ", applyTime=" + applyTime + ", applyType=" + applyType + ", linkStatus=" + linkStatus
				+ ", payStatus=" + payStatus + "]";
	}	
	
}
