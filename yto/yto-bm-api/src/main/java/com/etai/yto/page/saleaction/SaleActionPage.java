package com.etai.yto.page.saleaction;

import com.etai.yto.page.BasePage;

public class SaleActionPage extends BasePage{

	private static final long serialVersionUID = 1L;

	private String code; //活动码
	
	private String channelCode; //渠道编码
	
	private String partnerCode;
	
	private String startEffectTime; //生效时间
	
	private String endEffectTime; //生效时间
	
	private String startInvalidTime; //生效时间
	
	private String endInvalidTime; //生效时间
	
	private Integer limit;
	
	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
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

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getStartEffectTime() {
		return startEffectTime;
	}

	public void setStartEffectTime(String startEffectTime) {
		this.startEffectTime = startEffectTime;
	}

	public String getEndEffectTime() {
		return endEffectTime;
	}

	public void setEndEffectTime(String endEffectTime) {
		this.endEffectTime = endEffectTime;
	}

	public String getStartInvalidTime() {
		return startInvalidTime;
	}

	public void setStartInvalidTime(String startInvalidTime) {
		this.startInvalidTime = startInvalidTime;
	}

	public String getEndInvalidTime() {
		return endInvalidTime;
	}

	public void setEndInvalidTime(String endInvalidTime) {
		this.endInvalidTime = endInvalidTime;
	}
	
}
