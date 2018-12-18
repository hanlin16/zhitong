package com.etai.yto.model.underwriting;

import java.io.Serializable;

/**
 * 投保单信息节点
 * @author liushengli
 * @date 2018年7月17日
 */
public class Proposals implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6175430849723465947L;
	
	private String proposalNo;
	
	private String policyNo;
	
	private String riskCode;

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	@Override
	public String toString() {
		return "Proposals [proposalNo=" + proposalNo + ", policyNo=" + policyNo + ", riskCode=" + riskCode + "]";
	}
	
	
	/*"proposals": [
	              {
	                  "proposalNo": " T155005072015105130",
	                  "policyNo": "1155005072015001173",
	                  "riskCode": "0507"
	              }，
	  {
	                  "proposalNo": " T055105282016011988",
	                  "policyNo": "1265105282016000004",
	                  "riskCode": "0528"
	              }

	          ],*/

}
