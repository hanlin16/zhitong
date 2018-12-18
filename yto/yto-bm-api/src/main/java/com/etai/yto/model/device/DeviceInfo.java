package com.etai.yto.model.device;

import java.io.Serializable;

public class DeviceInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String providerCode; //供应商编码
	
	private String providerName; //供应商名称
	
	private String deviceCode; //设备标识
	
	private String deviceApplyId;
	
	private String type;
	
	private String name;
	
	private String status;
	
	private String loCompany; //物流公司
	
	private String loOrderNo; //物流单号
	
	public String getDeviceApplyId() {
		return deviceApplyId;
	}

	public void setDeviceApplyId(String deviceApplyId) {
		this.deviceApplyId = deviceApplyId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoCompany() {
		return loCompany;
	}

	public void setLoCompany(String loCompany) {
		this.loCompany = loCompany;
	}

	public String getLoOrderNo() {
		return loOrderNo;
	}

	public void setLoOrderNo(String loOrderNo) {
		this.loOrderNo = loOrderNo;
	}

	@Override
	public String toString() {
		return "DeviceInfo [id=" + id + ", providerCode=" + providerCode + ", providerName=" + providerName
				+ ", deviceCode=" + deviceCode + ", type=" + type + ", name=" + name + ", status=" + status
				+ ", loCompany=" + loCompany + ", loOrderNo=" + loOrderNo + "]";
	}

}
