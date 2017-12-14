package com.jinxin.manager.enumkit;

import com.jinxin.manager.util.ConfigUtil;

/**
 * Created by yzy on 2017/08/14 上午 10:11.
 * email: mia5121@163.com
 */
public interface Constants {

	//	String localShowPath = "http://localhost/";
	String localShowPath = ConfigUtil.getConfigValue("localShowPath");

//	String localUploadPath = "E:\\JinXin\\pics\\";

	String localUploadPath = ConfigUtil.getConfigValue("localUploadPath");

	String REDIS_ARTICLE_KEY = "article_detail_";

}
