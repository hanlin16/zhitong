package com.etai.yto.page;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean state;
	
	private Pager page;
	
	private List<T> dataList;
	
	private String errorMsg;
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Pager getPage() {
		return page;
	}

	public void setPage(Pager page) {
		this.page = page;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
}
