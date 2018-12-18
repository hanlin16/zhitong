package com.etai.yto.model.city;

import java.io.Serializable;

public class CityMappingModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String areaName;
	private String areaCode;
	private String areaLevel;
	private String areaSeq;
	private String areaLeaf;
	private String areaState;
	private int areaParentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	public String getAreaSeq() {
		return areaSeq;
	}
	public void setAreaSeq(String areaSeq) {
		this.areaSeq = areaSeq;
	}
	public String getAreaLeaf() {
		return areaLeaf;
	}
	public void setAreaLeaf(String areaLeaf) {
		this.areaLeaf = areaLeaf;
	}
	public String getAreaState() {
		return areaState;
	}
	public void setAreaState(String areaState) {
		this.areaState = areaState;
	}
	
	public int getAreaParentId() {
		return areaParentId;
	}
	public void setAreaParentId(int areaParentId) {
		this.areaParentId = areaParentId;
	}
	@Override
	public String toString() {
		return "CityMappingModel [id=" + id + ", areaName=" + areaName + ", areaCode=" + areaCode + ", areaLevel="
				+ areaLevel + ", areaSeq=" + areaSeq + ", areaLeaf=" + areaLeaf + ", areaState=" + areaState
				+ ", areaParentId=" + areaParentId + "]";
	}
	
}
