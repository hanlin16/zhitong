package com.etai.yto.model.underwriting;

import java.io.Serializable;

/**
 * 车辆信息节点
 * @author liushengli
 * @date 2018年7月17日
 */
public class VehicleInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1713317789855467717L;
	
	private String licenseNo;
	
	private String frameNo; //车架号
	
	private String engineNo;
	
	private String registerDate;
	
	private String vehicleModelCode;
	
	private String vehicleBrand;
	
	private String vehicleModelName;
	
	private String newCarPrice;
	
	private String seatCount;
	
	private String transferFlag;
	
	private String transferDate;
	
	private String loanFlag;

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getFrameNo() {
		return frameNo;
	}

	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getVehicleModelCode() {
		return vehicleModelCode;
	}

	public void setVehicleModelCode(String vehicleModelCode) {
		this.vehicleModelCode = vehicleModelCode;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModelName() {
		return vehicleModelName;
	}

	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}

	public String getNewCarPrice() {
		return newCarPrice;
	}

	public void setNewCarPrice(String newCarPrice) {
		this.newCarPrice = newCarPrice;
	}

	public String getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(String seatCount) {
		this.seatCount = seatCount;
	}

	public String getTransferFlag() {
		return transferFlag;
	}

	public void setTransferFlag(String transferFlag) {
		this.transferFlag = transferFlag;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public String getLoanFlag() {
		return loanFlag;
	}

	public void setLoanFlag(String loanFlag) {
		this.loanFlag = loanFlag;
	}

	@Override
	public String toString() {
		return "VehicleInfo [licenseNo=" + licenseNo + ", frameNo=" + frameNo + ", engineNo=" + engineNo
				+ ", registerDate=" + registerDate + ", vehicleModelCode=" + vehicleModelCode + ", vehicleBrand="
				+ vehicleBrand + ", vehicleModelName=" + vehicleModelName + ", newCarPrice=" + newCarPrice
				+ ", seatCount=" + seatCount + ", transferFlag=" + transferFlag + ", transferDate=" + transferDate
				+ ", loanFlag=" + loanFlag + "]";
	}
	
	
	
	 /*"vehicleInfo": {
        "licenseNo": "粤S52342",
        "frameNo": "23423423423423423",
        "engineNo": "234234234",
        "registerDate": "2014-12-19",
        "vehicleModelCode": "XFAAKD0013",
        "vehicleBrand": null,
        "vehicleModelName": "上汽通用雪佛兰1.4L赛欧手动档",
        "newCarPrice": "58800",
        "seatCount": "5",
        "transferFlag": "0",
        "transferDate": null,
        "loanFlag": "0"
    }*/

}
