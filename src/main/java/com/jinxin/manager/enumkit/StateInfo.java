package com.jinxin.manager.enumkit;

/**
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 */
public enum StateInfo {
	SUCCESS("1","成功"),
	FAILED("0","服务器异常,请稍后重试");

	private String code;
	private String message;

	private StateInfo(){}

	StateInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
