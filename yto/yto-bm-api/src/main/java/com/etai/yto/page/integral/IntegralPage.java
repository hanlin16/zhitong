package com.etai.yto.page.integral;

import java.io.Serializable;

import com.etai.yto.page.BasePage;

public class IntegralPage extends BasePage  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String partyCode;       //当事人编码
	private String partyPhoneNo;    //当事人手机号
	private String transactionItem;     //交易科目
	private String startTime;    //交易时间
	private String endTime;    //交易时间
	private String ruleCode;  //规则编码
	
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getPartyPhoneNo() {
		return partyPhoneNo;
	}
	public void setPartyPhoneNo(String partyPhoneNo) {
		this.partyPhoneNo = partyPhoneNo;
	}
	
	public String getTransactionItem() {
		return transactionItem;
	}

	public void setTransactionItem(String transactionItem) {
		this.transactionItem = transactionItem;
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

	@Override
	public String toString() {
		return "IntegralPage [partyCode=" + partyCode + ", partyPhoneNo=" + partyPhoneNo + ", transactionItem="
				+ transactionItem + ", startTime=" + startTime + ", endTime=" + endTime + ", ruleCode=" + ruleCode
				+ "]";
	}
	
	
}
