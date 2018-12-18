package com.etai.yto.model.device;

import java.io.Serializable;

public class DeviceType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id; //主键
	
	private String code; //类型编码,4位编码,从1001开始
	
	private String name; //类型名称
	
	private String providerCode; //供应商编码
	
	private String amount; //押金金额,默认值0
	
	private String status; //状态, 0-不可用;1-可用;默认1
	
	private String createUser; //创建人
	
	private String createTime; //创建时间
	
	private String updateUser; //最后修改人
	
	private String updateTime; //最后修改时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}	
	
}
