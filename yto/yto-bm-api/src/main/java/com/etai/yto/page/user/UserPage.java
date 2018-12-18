package com.etai.yto.page.user;

import com.etai.yto.page.BasePage;

public  class UserPage extends BasePage {

	private static final long serialVersionUID = 1L;

	private String userName;
	
	private Integer status;
	
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
