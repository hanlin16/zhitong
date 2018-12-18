package com.etai.yto.model.integral;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 积分明细
 * @author king
 *
 */
public class IntegralDetailModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;                  //主键
	private int integralId;          //积分id
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date transactionTime;    //交易时间
	private int transactionItem;     //交易科目
	private int itemType;            //科目类别
	private String orderNo;          //订单编码
	private int amount;              //交易积分
	private int balance;             //积分余额
	private String remark;           //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIntegralId() {
		return integralId;
	}
	public void setIntegralId(int integralId) {
		this.integralId = integralId;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public int getTransactionItem() {
		return transactionItem;
	}
	public void setTransactionItem(int transactionItem) {
		this.transactionItem = transactionItem;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "IntegralDetailModel [id=" + id + ", integralId=" + integralId + ", transactionTime=" + transactionTime
				+ ", transactionItem=" + transactionItem + ", itemType=" + itemType + ", orderNo=" + orderNo
				+ ", amount=" + amount + ", balance=" + balance + ", remark=" + remark + "]";
	}
	
}
