package com.etai.yto.page.companypartner;

import com.etai.yto.page.BasePage;

public class CompanyPartnerPage extends BasePage {

	private static final long serialVersionUID = 1L;

	private String fullName;
	
	private String shortName;
	
	private String code;
	
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getFullName() {
		return fullName!=null?fullName.trim():null;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName!=null?shortName.trim():null;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCode() {
		return code!=null?code.trim():null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CompanyPartnerPage [fullName=" + fullName + ", shortName=" + shortName + ", code=" + code + ", limit="
				+ limit + "]";
	}	
}
