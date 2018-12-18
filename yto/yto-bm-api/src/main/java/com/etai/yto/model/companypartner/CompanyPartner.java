package com.etai.yto.model.companypartner;

import java.io.Serializable;
import java.util.Date;

public class CompanyPartner implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;  //主键
	
	private String code;  //编码
	
	private String fullName; //全称
	
	private String shortName; //简称
	
	private String linkman; //联系人
	
	private String linkmanPhoneNo;  //联系人电话
	
	private String linkmanEmail; //联系人邮箱
	
	private String areaCode;  //所在地编码
	
	private String areaName;
	
	private Date createTime; //创建时间
	
	private String createUser; //创建人
	
	private Date updateTime;  //修改时间
	
	private String updateUser;  //修改人
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public String getFullName() {
		return fullName==null?null:fullName.trim();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName==null?null:shortName.trim();
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanPhoneNo() {
		return linkmanPhoneNo;
	}

	public void setLinkmanPhoneNo(String linkmanPhoneNo) {
		this.linkmanPhoneNo = linkmanPhoneNo;
	}

	public String getLinkmanEmail() {
		return linkmanEmail;
	}

	public void setLinkmanEmail(String linkmanEmail) {
		this.linkmanEmail = linkmanEmail;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}	
}
