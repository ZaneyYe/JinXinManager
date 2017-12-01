package com.jinxin.manager.vo;

import com.jinxin.manager.enumkit.StateInfo;

/**
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 * @author yezhangyuan
 */
public class BaseResponse {

	private String code = StateInfo.SUCCESS.getCode();
	private String message = StateInfo.SUCCESS.getMessage();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
