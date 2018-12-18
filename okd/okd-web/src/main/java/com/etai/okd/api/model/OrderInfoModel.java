package com.etai.okd.api.model;

import java.io.Serializable;

/**
 * 公众号订单明细实体类
 * @author king
 *
 */
public class OrderInfoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNo;   //订单编号
	private String productName; //商品名称
	private String number;    //商品数量
	private String payMoney;  //支付金额
	private String payType;   //支付方式
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	@Override
	public String toString() {
		return "OrderInfoModel [orderNo=" + orderNo + ", productName=" + productName + ", number=" + number
				+ ", payMoney=" + payMoney + ", payType=" + payType + "]";
	}
	
}
