package com.etai.yto.model.proposal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.model.underwriting.PersonInfo;
import com.etai.yto.model.underwriting.VehicleInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProposalModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bizId;//	智通业务号	String(20)	Y	
	private BigDecimal totalCredits;//	结算积分	String(10)	Y	390.00
	private BigDecimal biPremium;//	商业险总保费	String(10)	Y	1300.00
	private BigDecimal ciPremium;//	交强险总保费	String(10)	Y	750.00
	private BigDecimal vehicleTaxPremium;//	车船税	String(10)	Y	350.00
	private BigDecimal sumPremium;//	总保费	String(10)	Y	2400.00
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date biStartDate;//	商业险起保日期	String(10)	N	yyyy-MM-dd
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date biEndDate;//	商业险终保日期	String(10)	N	yyyy-MM-dd
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date ciStartDate;//	交强险起保日期	String(10)	N	yyyy-MM-dd
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date ciEndDate;//	交强险终保日期	String(10)	N	yyyy-MM-dd
	private BigDecimal balanceCiIntegral;//	结算交强险积分	String(20)	N	结算交强险积分
	private BigDecimal balanceBiIntegral;//	结算商业险积分	String(20)	N	结算商业险积分
	private BigDecimal balanceCiCost;//	结算交强险费率	String(20)	N	用来计算结算交强险积分
	private BigDecimal balanceBiCost;//	结算商业险费率	String(20)	N	用来计算结算商业险积分
	private String cityCode;//	城市代码	String(8)	Y	国标码
	private String cityName;//	城市名称	String(50)	Y	
	private String provinceCode;//	省份代码	String(8)	Y	国标码
	private String provinceName;//	省份名称	String(50)	Y	
	private String agentCode;//	第三方标识	String(30)	Y	由智通分配的标识
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date payTime;//	支付时间	String(19)	Y	yyyy-MM-dd HH:mm:ss
	private BigDecimal payMoney;//	支付金额	String(10)	Y	
	private String insurerCode;//	保险公司代码	String(50)	Y	
	private String insurerName;//	保险公司代码	String(50)	Y	
	private VehicleInfo vehicleInfo;//	车辆信息节点	Object	Y	见vehicleInfo节点说明
	private PersonInfo personInfo;//	人员信息节点	Object	Y	见personInfo节点说明
	private List<Kinds> kinds;//	险种信息集合	List	Y	见kinds节点说明
	private String biProposalNo;
	private String biPolicyNo;
	private String ciProposalNo;
	private String ciPolicyNo;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date acceptTime;//同步时间
	
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public BigDecimal getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(BigDecimal totalCredits) {
		this.totalCredits = totalCredits;
	}
	public BigDecimal getBiPremium() {
		return biPremium;
	}
	public void setBiPremium(BigDecimal biPremium) {
		this.biPremium = biPremium;
	}
	public BigDecimal getCiPremium() {
		return ciPremium;
	}
	public void setCiPremium(BigDecimal ciPremium) {
		this.ciPremium = ciPremium;
	}
	public BigDecimal getVehicleTaxPremium() {
		return vehicleTaxPremium;
	}
	public void setVehicleTaxPremium(BigDecimal vehicleTaxPremium) {
		this.vehicleTaxPremium = vehicleTaxPremium;
	}
	public BigDecimal getSumPremium() {
		return sumPremium;
	}
	public void setSumPremium(BigDecimal sumPremium) {
		this.sumPremium = sumPremium;
	}
	public Date getBiStartDate() {
		return biStartDate;
	}
	public void setBiStartDate(Date biStartDate) {
		this.biStartDate = biStartDate;
	}
	public Date getBiEndDate() {
		return biEndDate;
	}
	public void setBiEndDate(Date biEndDate) {
		this.biEndDate = biEndDate;
	}
	public Date getCiStartDate() {
		return ciStartDate;
	}
	public void setCiStartDate(Date ciStartDate) {
		this.ciStartDate = ciStartDate;
	}
	public Date getCiEndDate() {
		return ciEndDate;
	}
	public void setCiEndDate(Date ciEndDate) {
		this.ciEndDate = ciEndDate;
	}
	public BigDecimal getBalanceCiIntegral() {
		return balanceCiIntegral;
	}
	public void setBalanceCiIntegral(BigDecimal balanceCiIntegral) {
		this.balanceCiIntegral = balanceCiIntegral;
	}
	public BigDecimal getBalanceBiIntegral() {
		return balanceBiIntegral;
	}
	public void setBalanceBiIntegral(BigDecimal balanceBiIntegral) {
		this.balanceBiIntegral = balanceBiIntegral;
	}
	public BigDecimal getBalanceCiCost() {
		return balanceCiCost;
	}
	public void setBalanceCiCost(BigDecimal balanceCiCost) {
		this.balanceCiCost = balanceCiCost;
	}
	public BigDecimal getBalanceBiCost() {
		return balanceBiCost;
	}
	public void setBalanceBiCost(BigDecimal balanceBiCost) {
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
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	public String getInsurerCode() {
		return insurerCode;
	}
	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
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
	@Override
	public String toString() {
		return "ProposalModel [bizId=" + bizId + ", totalCredits=" + totalCredits + ", biPremium=" + biPremium
				+ ", ciPremium=" + ciPremium + ", vehicleTaxPremium=" + vehicleTaxPremium + ", sumPremium=" + sumPremium
				+ ", biStartDate=" + biStartDate + ", biEndDate=" + biEndDate + ", ciStartDate=" + ciStartDate
				+ ", ciEndDate=" + ciEndDate + ", balanceCiIntegral=" + balanceCiIntegral + ", balanceBiIntegral="
				+ balanceBiIntegral + ", balanceCiCost=" + balanceCiCost + ", balanceBiCost=" + balanceBiCost
				+ ", cityCode=" + cityCode + ", cityName=" + cityName + ", provinceCode=" + provinceCode
				+ ", provinceName=" + provinceName + ", agentCode=" + agentCode + ", payTime=" + payTime + ", payMoney="
				+ payMoney + ", insurerCode=" + insurerCode + ", insurerName=" + insurerName + ", vehicleInfo="
				+ vehicleInfo + ", personInfo=" + personInfo + ", kinds=" + kinds + ", biProposalNo=" + biProposalNo
				+ ", biPolicyNo=" + biPolicyNo + ", ciProposalNo=" + ciProposalNo + ", ciPolicyNo=" + ciPolicyNo
				+ ", acceptTime=" + acceptTime + "]";
	}
	
}
