package com.etai.yto.model.salechannel;

import java.io.Serializable;
import java.util.Date;

public class SaleChannel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id; //主键
	
	private String code; //编码
	
	private String name; //名称
	
	private String partnerCode; //合作伙伴编码
	
	private String partnerName;//合作伙伴名称
	
	private String status; //状态
	
	private String remark; //备注
	
	private Date createTime; //创建时间
	
	private String createUser; //创建人
	
	private Date updateTime; //修改时间
	
	private String updateUser; //修改人

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
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

	public String getName() {
		return name==null?null:name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
