package com.jinxin.manager.util;

import java.util.ResourceBundle;

/**
 * Created by yzy on 2017/12/14.
 * email: mia5121@163.com
 */
public class ConfigUtil {


	public static String getConfigValue(String configKey) {
		ResourceBundle bundle = ResourceBundle.getBundle("conf");
		if (bundle.containsKey(configKey)) {
			String value = bundle.getString(configKey);
			return value;
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(getConfigValue("localShowPath"));
	}
}
