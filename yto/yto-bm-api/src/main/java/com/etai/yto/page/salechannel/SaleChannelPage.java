package com.etai.yto.page.salechannel;

import com.etai.yto.page.BasePage;

public class SaleChannelPage extends BasePage{

	private static final long serialVersionUID = 1L;

	private String partnerCode; //合作伙伴编码
	
	private String code; //编码
	
	private String status; //状态
	
	private Integer limit;
	
	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getCode() {
		return code==null?null:code.trim();
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
