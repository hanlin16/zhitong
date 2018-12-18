package com.etai.yto.model.integral;

import java.io.Serializable;
/**
 * 积分规则定义
 * @author king
 *
 */
public class IntegralRuleDefModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;           //主键
	private String ruleCode;  //规则编码
	private int serialNo;     //序号
	private int gradeFrom;    //评分起始数
	private int gradeEnd;     //评分终止数
	private int integral;     //积分
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getGradeFrom() {
		return gradeFrom;
	}
	public void setGradeFrom(int gradeFrom) {
		this.gradeFrom = gradeFrom;
	}
	public int getGradeEnd() {
		return gradeEnd;
	}
	public void setGradeEnd(int gradeEnd) {
		this.gradeEnd = gradeEnd;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	@Override
	public String toString() {
		return "IntegralRuleDefModel [id=" + id + ", ruleCode=" + ruleCode + ", serialNo=" + serialNo + ", gradeFrom="
				+ gradeFrom + ", gradeEnd=" + gradeEnd + ", integral=" + integral + "]";
	}
	
}
