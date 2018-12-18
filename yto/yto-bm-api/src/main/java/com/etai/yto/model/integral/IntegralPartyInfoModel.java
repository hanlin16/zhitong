package com.etai.yto.model.integral;

import java.io.Serializable;
import java.util.Date;

/**
 * 当事人信息表
 * @author king
 *
 */
public class IntegralPartyInfoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;            //主键
	private String code;       //编码
	private String phoneNo;    //手机号
	private String name;       //姓名
	private String email;      //邮箱
	private Date createTime;   //创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "IntegralPartyInfoModel [id=" + id + ", code=" + code + ", phoneNo=" + phoneNo + ", name=" + name
				+ ", email=" + email + ", createTime=" + createTime + "]";
	}
	
}
