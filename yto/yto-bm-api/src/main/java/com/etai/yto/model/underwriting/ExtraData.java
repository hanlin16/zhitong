package com.etai.yto.model.underwriting;

import java.io.Serializable;

public class ExtraData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1801528813325198111L;
	
	/*  bi_proposal_no	商业投保单号
		bi_policy_no	商业保单号
		ci_proposal_no	交强投保单号
		ci_policy_no	交强保单号
		bind_status	绑定状态
		relation_status	关联状态
		device_no	设备编号*/
	
	private  String biProposalNo;
	
	private String biPolicyNo;
	
	private String ciProposalNo;
	
	private String ciPolicyNo;
	
	private Integer bindStatus;
	
	private Integer relationStatus;
	
	private String deviceNo;
	
	private String acceptTime;

	public String getBiProposalNo() {
		return biProposalNo;
	}

	public void setBiProposalNo(String biProposalNo) {
		this.biProposalNo = biProposalNo;
	}

	public String getBiPolicyNo() {
		return biPolicyNo;
	}

	public void setBiPolicyNo(String biPolicyNo) {
		this.biPolicyNo = biPolicyNo;
	}

	public String getCiProposalNo() {
		return ciProposalNo;
	}

	public void setCiProposalNo(String ciProposalNo) {
		this.ciProposalNo = ciProposalNo;
	}

	public String getCiPolicyNo() {
		return ciPolicyNo;
	}

	public void setCiPolicyNo(String ciPolicyNo) {
		this.ciPolicyNo = ciPolicyNo;
	}

	public Integer getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(Integer bindStatus) {
		this.bindStatus = bindStatus;
	}

	public Integer getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(Integer relationStatus) {
		this.relationStatus = relationStatus;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	@Override
	public String toString() {
		return "ExtraData [biProposalNo=" + biProposalNo + ", biPolicyNo=" + biPolicyNo + ", ciProposalNo="
				+ ciProposalNo + ", ciPolicyNo=" + ciPolicyNo + ", bindStatus=" + bindStatus + ", relationStatus="
				+ relationStatus + ", deviceNo=" + deviceNo + ", acceptTime=" + acceptTime + "]";
	}
}
