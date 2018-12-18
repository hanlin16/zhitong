package com.etai.yto.page.device;

import java.io.Serializable;

import com.etai.yto.page.BasePage;

public class DeviceApplyPage extends BasePage implements Serializable{

	private static final long serialVersionUID = 5954599076944529576L;
	
	private String receiver;
	private String applyType;
	private String channelCode;
	private String bizNo;
	private Integer linkStatus;
	private String actionCode;
	
	private String startDate;
	
	private String endDate;
	private String limit;
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
	
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "DeviceApplyPage [receiver=" + receiver + ", applyType=" + applyType + ", channelCode=" + channelCode
				+ ", bizNo=" + bizNo + ", linkStatus=" + linkStatus + ", actionCode=" + actionCode + ", startDate="
				+ startDate + ", endDate=" + endDate + ", limit=" + limit + "]";
	}
	
	

}
