package com.etai.yto.model.underwriting;

import java.io.Serializable;
import java.util.List;

public class WritingData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3096186038978334238L;
	
	
	private String bizId;//	智通业务号	String(20)	Y	
	private String thpBizId;//	第三方业务号	String(36)	N	
	private String totalCredits;//	结算积分	String(10)	Y	390.00
	private String biPremium;//	商业险总保费	String(10)	Y	1300.00
	private String ciPremium;//	交强险总保费	String(10)	Y	750.00
	private String vehicleTaxPremium;//	车船税	String(10)	Y	350.00
	private String sumPremium;//	总保费	String(10)	Y	2400.00
	private String biStartDate;//	商业险起保日期	String(10)	N	yyyy-MM-dd
	private String biEndDate;//	商业险终保日期	String(10)	N	yyyy-MM-dd
	private String ciStartDate;//	交强险起保日期	String(10)	N	yyyy-MM-dd
	private String ciEndDate;//	交强险终保日期	String(10)	N	yyyy-MM-dd
	private String balanceCiIntegral;//	结算交强险积分	String(20)	N	结算交强险积分
	private String balanceBiIntegral;//	结算商业险积分	String(20)	N	结算商业险积分
	private String balanceCiCost;//	结算交强险费率	String(20)	N	用来计算结算交强险积分
	private String balanceBiCost;//	结算商业险费率	String(20)	N	用来计算结算商业险积分
	private String cityCode;//	城市代码	String(8)	Y	国标码
	private String cityName;//	城市名称	String(50)	Y	
	private String provinceCode;//	省份代码	String(8)	Y	国标码
	private String provinceName;//	省份名称	String(50)	Y	
	private String cloudFlag;//	电销标识	String（10）	N	1：电销成单
	private String agentCode;//	第三方标识	String(30)	Y	由智通分配的标识
	private String payTime;//	支付时间	String(19)	Y	yyyy-MM-dd HH:mm:ss
	private String payMoney;//	支付金额	String(10)	Y	
	private String insurerCode;//	保险公司代码	String(50)	Y	
	private String accountNo;//	投保用户标示	String(50)	N	投保用户标示
	private VehicleInfo vehicleInfo;//	车辆信息节点	Object	Y	见vehicleInfo节点说明
	private PersonInfo personInfo;//	人员信息节点	Object	Y	见personInfo节点说明
	private List<Kinds> kinds;//	险种信息集合	List	Y	见kinds节点说明
	private List<Proposals> proposals;//	投保单信息	List	Y	见proposals节点说明
	private List<Agreements> agreements;//	特约信息集合	List	N	见agreements节点说明，可能为空
	
	
	public String getBizId() {
		return bizId;
	}


	public void setBizId(String bizId) {
		this.bizId = bizId;
	}


	public String getThpBizId() {
		return thpBizId;
	}


	public void setThpBizId(String thpBizId) {
		this.thpBizId = thpBizId;
	}


	public String getTotalCredits() {
		return totalCredits;
	}


	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}


	public String getBiPremium() {
		return biPremium;
	}


	public void setBiPremium(String biPremium) {
		this.biPremium = biPremium;
	}


	public String getCiPremium() {
		return ciPremium;
	}


	public void setCiPremium(String ciPremium) {
		this.ciPremium = ciPremium;
	}


	public String getVehicleTaxPremium() {
		return vehicleTaxPremium;
	}


	public void setVehicleTaxPremium(String vehicleTaxPremium) {
		this.vehicleTaxPremium = vehicleTaxPremium;
	}


	public String getSumPremium() {
		return sumPremium;
	}


	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}


	public String getBiStartDate() {
		return biStartDate;
	}


	public void setBiStartDate(String biStartDate) {
		this.biStartDate = biStartDate;
	}


	public String getBiEndDate() {
		return biEndDate;
	}


	public void setBiEndDate(String biEndDate) {
		this.biEndDate = biEndDate;
	}


	public String getCiStartDate() {
		return ciStartDate;
	}


	public void setCiStartDate(String ciStartDate) {
		this.ciStartDate = ciStartDate;
	}


	public String getCiEndDate() {
		return ciEndDate;
	}


	public void setCiEndDate(String ciEndDate) {
		this.ciEndDate = ciEndDate;
	}


	public String getBalanceCiIntegral() {
		return balanceCiIntegral;
	}


	public void setBalanceCiIntegral(String balanceCiIntegral) {
		this.balanceCiIntegral = balanceCiIntegral;
	}


	public String getBalanceBiIntegral() {
		return balanceBiIntegral;
	}


	public void setBalanceBiIntegral(String balanceBiIntegral) {
		this.balanceBiIntegral = balanceBiIntegral;
	}


	public String getBalanceCiCost() {
		return balanceCiCost;
	}


	public void setBalanceCiCost(String balanceCiCost) {
		this.balanceCiCost = balanceCiCost;
	}


	public String getBalanceBiCost() {
		return balanceBiCost;
	}


	public void setBalanceBiCost(String balanceBiCost) {
		this.balanceBiCost = balanceBiCost;
	}


	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getProvinceCode() {
		return provinceCode;
	}


	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}


	public String getCloudFlag() {
		return cloudFlag;
	}


	public void setCloudFlag(String cloudFlag) {
		this.cloudFlag = cloudFlag;
	}


	public String getAgentCode() {
		return agentCode;
	}


	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}


	public String getPayTime() {
		return payTime;
	}


	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}


	public String getPayMoney() {
		return payMoney;
	}


	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}


	public String getInsurerCode() {
		return insurerCode;
	}


	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
	}


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}


	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}


	public PersonInfo getPersonInfo() {
		return personInfo;
	}


	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}


	public List<Kinds> getKinds() {
		return kinds;
	}


	public void setKinds(List<Kinds> kinds) {
		this.kinds = kinds;
	}


	public List<Proposals> getProposals() {
		return proposals;
	}


	public void setProposals(List<Proposals> proposals) {
		this.proposals = proposals;
	}


	public List<Agreements> getAgreements() {
		return agreements;
	}


	public void setAgreements(List<Agreements> agreements) {
		this.agreements = agreements;
	}


	@Override
	public String toString() {
		return "WritingData [bizId=" + bizId + ", thpBizId=" + thpBizId + ", totalCredits=" + totalCredits
				+ ", biPremium=" + biPremium + ", ciPremium=" + ciPremium + ", vehicleTaxPremium=" + vehicleTaxPremium
				+ ", sumPremium=" + sumPremium + ", biStartDate=" + biStartDate + ", biEndDate=" + biEndDate
				+ ", ciStartDate=" + ciStartDate + ", ciEndDate=" + ciEndDate + ", balanceCiIntegral="
				+ balanceCiIntegral + ", balanceBiIntegral=" + balanceBiIntegral + ", balanceCiCost=" + balanceCiCost
				+ ", balanceBiCost=" + balanceBiCost + ", cityCode=" + cityCode + ", cityName=" + cityName
				+ ", provinceCode=" + provinceCode + ", provinceName=" + provinceName + ", cloudFlag=" + cloudFlag
				+ ", agentCode=" + agentCode + ", payTime=" + payTime + ", payMoney=" + payMoney + ", insurerCode="
				+ insurerCode + ", accountNo=" + accountNo + ", vehicleInfo=" + vehicleInfo + ", personInfo="
				+ personInfo + ", kinds=" + kinds + ", proposals=" + proposals + ", agreements=" + agreements + "]";
	}
	

}
