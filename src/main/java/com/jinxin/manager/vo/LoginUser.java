package com.jinxin.manager.vo;

/**
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 */
public class LoginUser {
	//用户名
	private String name;
	//密码
	private String password;
	//盐
	private String salt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
