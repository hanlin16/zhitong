package com.etai.yto.model.underwriting;

import java.io.Serializable;

public class WritingReceive implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3179114606802903436L;
	
	
	private String state;
	
	private String message;
	
	private WritingData data;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public WritingData getData() {
		return data;
	}

	public void setData(WritingData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WritingReceive [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
}
