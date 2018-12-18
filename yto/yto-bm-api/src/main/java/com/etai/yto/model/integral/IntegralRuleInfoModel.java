package com.etai.yto.model.integral;

import java.io.Serializable;
/**
 * 积分信息
 * @author king
 *
 */
public class IntegralRuleInfoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;                 //主键
	private String partyCode;       //当事人编码
	private String name;       //当事人名字
	private String partyPhoneNo;    //当事人手机号
	private int integralIncome;     //收入积分
	private int integralUsable;     //可用积分
	private int integralPayout;     //已提积分
	private int integralLock;       //冻结积分
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartyPhoneNo() {
		return partyPhoneNo;
	}
	public void setPartyPhoneNo(String partyPhoneNo) {
		this.partyPhoneNo = partyPhoneNo;
	}
	public int getIntegralIncome() {
		return integralIncome;
	}
	public void setIntegralIncome(int integralIncome) {
		this.integralIncome = integralIncome;
	}
	public int getIntegralUsable() {
		return integralUsable;
	}
	public void setIntegralUsable(int integralUsable) {
		this.integralUsable = integralUsable;
	}
	public int getIntegralPayout() {
		return integralPayout;
	}
	public void setIntegralPayout(int integralPayout) {
		this.integralPayout = integralPayout;
	}
	public int getIntegralLock() {
		return integralLock;
	}
	public void setIntegralLock(int integralLock) {
		this.integralLock = integralLock;
	}
	@Override
	public String toString() {
		return "IntegralRuleInfoModel [id=" + id + ", partyCode=" + partyCode + ", name=" + name + ", partyPhoneNo="
				+ partyPhoneNo + ", integralIncome=" + integralIncome + ", integralUsable=" + integralUsable
				+ ", integralPayout=" + integralPayout + ", integralLock=" + integralLock + "]";
	}
	
}
