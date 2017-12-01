package com.jinxin.manager.vo;

/**
 * @author yezhangyuan
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 * Json返回体
 */
public class ResponseEntity<T> extends BaseResponse {

	private T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}


}

