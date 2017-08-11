package com.jinxin.manager.vo;

/**
 * Created by yzy on 2017/08/11 上午 10:54.
 * email: mia5121@163.com
 */
public class RequestPage {
	private Integer page;

	private Integer rows;

	private Integer start;


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		if(page > 1){
			return (page - 1) * rows;
		}
		return 0;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}
