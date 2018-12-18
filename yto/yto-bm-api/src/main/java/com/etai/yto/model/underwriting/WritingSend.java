package com.etai.yto.model.underwriting;

import java.io.Serializable;

public class WritingSend implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6347139002676524550L;

	private String state;
	
	private String message;
	
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

	@Override
	public String toString() {
		return "WritingReceive [state=" + state + ", message=" + message + "]";
	}
}
