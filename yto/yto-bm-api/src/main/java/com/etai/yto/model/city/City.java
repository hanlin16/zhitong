package com.etai.yto.model.city;

import java.io.Serializable;

public class City implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cityId;
	
	private String city;
	
	private String remark;
	
	private String spelling;
	
	private String proGb;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public String getProGb() {
		return proGb;
	}

	public void setProGb(String proGb) {
		this.proGb = proGb;
	}	
}
