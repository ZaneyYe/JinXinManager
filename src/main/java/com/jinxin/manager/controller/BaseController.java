package com.jinxin.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/6/7.
 * email: mia5121@163.com
 */
@Controller
@RequestMapping("/")
public class BaseController {

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


	/**
	 * 跳转登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/login_toLogin")
	public String toLoginPage(HttpServletRequest request){
		return "login";
	}


	@RequestMapping("/admin.do")
	public String toIndexPage(){
		return "system/admin";
	}


	@RequestMapping("/img_manage.do")
    public String toImageInfoPage(){
		return "system/img";
	}

	@RequestMapping("/toManager.do")
	public String toManager() {
		return "system/manager";
	}

}
