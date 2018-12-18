package com.etai.yto.model.syscode;

import java.io.Serializable;

public class EightCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4671430452976638368L;
	
	
	private Integer id;//主键
	private String code;//8位编码
	
	private String status;//状态,0-未使用;1-已使用
	
	private String createTime;//生成时间
	
	private String createUser;//'生成者
	
	private String batchNo;//批次号
	
	private String useTime;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	@Override
	public String toString() {
		return "EightCode [id=" + id + ", code=" + code + ", status=" + status + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", batchNo=" + batchNo + ", useTime=" + useTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EightCode other = (EightCode) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}	
	
}
