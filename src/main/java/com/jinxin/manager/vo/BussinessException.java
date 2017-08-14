package com.jinxin.manager.vo;

/**
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 */
public class BussinessException extends RuntimeException {
	/**
	 * 异常状态码
	 */
	private String errorCode;
	/**
	 * 异常消息
	 */
	private String message;

	public BussinessException(){}

	public BussinessException(String message) {
		super(message);
	}

	public BussinessException(String errorCode,String message){
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
