package com.etai.yto.model.integral;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 积分规则
 * @author king
 *
 */
public class IntegralRuleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;                 //主键
	private String ruleCode;       //规则编码
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date startDate;        //起期
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date endDate;          //止期
	private int versionNo;         //版本号
	private int versionStatus;     //状态
	private String createUser;     //创建人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;       //创建时间
	private String updateUser;     //最后修改人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime;       //最后修改时间
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
	public int getVersionStatus() {
		return versionStatus;
	}
	public void setVersionStatus(int versionStatus) {
		this.versionStatus = versionStatus;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "IntegralRuleModel [id=" + id + ", ruleCode=" + ruleCode + ", startDate=" + startDate + ", endDate="
				+ endDate + ", versionNo=" + versionNo + ", versionStatus=" + versionStatus + ", createUser="
				+ createUser + ", createTime=" + createTime + ", updateUser=" + updateUser + ", updateTime="
				+ updateTime + "]";
	}
	
}
