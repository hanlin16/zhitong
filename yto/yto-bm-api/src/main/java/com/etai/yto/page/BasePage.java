package com.etai.yto.page;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;


public class BasePage implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8500421820296852512L;
	// 当前页
	private int page = 1;
	// 每页行数
	private int rows = 10;
	// 总页码
	private int rowCount;

	private String sort;

	private String order;

	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();

	public Pager getPager() {
		pager.setPageId(getPage());
		pager.setPageSize(getRows());
		pager.setRowCount(getRowCount());
		String orderField = "";
		if (StringUtils.isNotBlank(sort)) {
			orderField = sort;
		}
		if (StringUtils.isNotBlank(orderField) && StringUtils.isNotBlank(order)) {
			orderField += " " + order;
		}
		pager.setOrderField(orderField);
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	@Override
	public String toString() {
		return "BasePage [page=" + page + ", rows=" + rows + ", rowCount=" + rowCount + ", sort=" + sort + ", order="
				+ order + ", pager=" + pager + "]";
	}
}
