package com.etai.yto.model.underwriting;

import java.io.Serializable;
/**
 * 险种信息节点
 * @author liushengli
 * @date 2018年7月17日
 */
public class Kinds implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8253622768647846287L;
	
	private String kindCode;
	
	private String kindName;
	
	private String amount;
	
	private String premium;
	
	private String riskCode;
	
	private String deductibleFlag;
	
	private String flag;

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getDeductibleFlag() {
		return deductibleFlag;
	}

	public void setDeductibleFlag(String deductibleFlag) {
		this.deductibleFlag = deductibleFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Kinds [kindCode=" + kindCode + ", kindName=" + kindName + ", amount=" + amount + ", premium=" + premium
				+ ", riskCode=" + riskCode + ", deductibleFlag=" + deductibleFlag + ", flag=" + flag + "]";
	}
	/* "kinds": [
	            {
	                "kindCode": "MD4",
	                "kindName": "不计免赔险(乘客责任险)",
	                "amount": "1",
	                "premium": "41.55",
	                "riskCode": "0528",
	                "deductibleFlag": "1",
	                "flag": null
	            }]*/

}
