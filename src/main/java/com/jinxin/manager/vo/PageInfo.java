package com.jinxin.manager.vo;

/**
 * Created by yzy on 2017/08/10 下午 3:07.
 * email: mia5121@163.com
 */
public class PageInfo<T> {

	/**
	 * 总条数
	 */
	private Integer total;
	/**
	 * 当前页的data
	 */
	private T rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}
}
