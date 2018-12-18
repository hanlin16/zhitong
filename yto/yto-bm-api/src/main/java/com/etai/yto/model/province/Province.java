package com.etai.yto.model.province;

import java.io.Serializable;

public class Province implements Serializable{

	private static final long serialVersionUID = 1L;

	private String proId;
	
	private String province;
	
	private String shortname;
	
	private String spelling;
	
	private String isDel;
	
	private String proIdGb;

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getProIdGb() {
		return proIdGb;
	}

	public void setProIdGb(String proIdGb) {
		this.proIdGb = proIdGb;
	}
		
}
