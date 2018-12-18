package com.etai.yto.model.preinfo;

public class PreInfoModel {

	private String actionCode;
	private String licenceNo;
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	@Override
	public String toString() {
		return "PreInfoModel [actionCode=" + actionCode + ", licenceNo=" + licenceNo + "]";
	}
	
}
