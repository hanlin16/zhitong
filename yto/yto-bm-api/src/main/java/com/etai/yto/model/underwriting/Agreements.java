package com.etai.yto.model.underwriting;

import java.io.Serializable;
/**
 * 特约信息节点
 * @author liushengli
 * @date 2018年7月17日
 */
public class Agreements implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8488253442550584800L;
	
	private String code;
	
	private String name;
	
	private String content;
	
	private String riskCode;

	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRiskCode() {
		return riskCode;
	}


	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}


	@Override
	public String toString() {
		return "Agreements [code=" + code + ", name=" + name + ", content=" + content + ", riskCode=" + riskCode + "]";
	}
	
    /*
     * "agreements": [
                   {
                       "code": "T163",
                       "name": "非营运",
                       "content": "本保单项下的保险车辆为非营运用车，若从事营运活动，出险后保险人不负责赔偿责任。",
                       "riskCode": "0528"
                   }
     ]
    */

}
