package com.etai.yto.model.saleaction;

import java.io.Serializable;

public class SaleAction implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id; //主键
	
	private String code; //活动码
	
	private String channelCode; //渠道编码
	
	private String channelName;//渠道名称
	
	private String deviceType;
	
	private String partnerCode;
	
	private String partnerName;
	
	private String startTime; //生效时间
	
	private String endTime; //失效时间
	
	private String deviceApplyUrl;
	
	private String createTime; //创建时间
	
	private String createUser; //创建人
	
	private String updateTime; //修改时间
	
	private String updateUser; //修改人
	
	private String remark;
	
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

	public String getDeviceApplyUrl() {
		return deviceApplyUrl;
	}

	public void setDeviceApplyUrl(String deviceApplyUrl) {
		this.deviceApplyUrl = deviceApplyUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}	
}
