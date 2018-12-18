package com.etai.okd.api.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信统一下单请求实体类
 * @author king
 *
 */
@XmlRootElement(name="xml")
public class UnifiedOrderRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appid;      //公众账号ID
	private String mch_id;     //商户号
	private String nonce_str;  //随机字符串,长度要求在32位以内
	private String sign;       //签名微信签名算法
	private String body;       //商品描述
	private String out_trade_no;//商户订单号
	private int total_fee;  //标价金额,单位为分
	private String spbill_create_ip;//终端ip:APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	private String notify_url; //通知地址
	private String trade_type; //交易类型
	private String openid;     //用户表示 调微信公众号平台获取用户的openid
	private String sign_type;  //加密类型
	
	@XmlElement(name="appid")
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	@XmlElement(name="mch_id")
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	@XmlElement(name="nonce_str")
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	@XmlElement(name="sign")
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@XmlElement(name="body")
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@XmlElement(name="out_trade_no")
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		
		this.out_trade_no = out_trade_no;
	}
	@XmlElement(name="total_fee")
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	@XmlElement(name="spbill_create_ip")
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	@XmlElement(name="notify_url")
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	@XmlElement(name="trade_type")
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	@XmlElement(name="openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	@Override
	public String toString() {
		return "UnifiedOrderRequestModel [appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str
				+ ", sign=" + sign + ", body=" + body + ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee
				+ ", spbill_create_ip=" + spbill_create_ip + ", notify_url=" + notify_url + ", trade_type=" + trade_type
				+ ", openid=" + openid + ", sign_type=" + sign_type + "]";
	}
	
}
