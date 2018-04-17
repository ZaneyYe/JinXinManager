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

	/**
	 * 主页
	 *
	 * @return
	 */
	@RequestMapping("/admin.do")
	public String toIndexPage(){
		return "system/admin";
	}

	/**
	 * 图片管理
	 * @return
	 */
	@RequestMapping("/img_manage.do")
	public String toImageInfoPage(){
		return "system/img";
	}

	/**
	 * 用户管理
	 * @return
	 */
	@RequestMapping("/toManager.do")
	public String toManager() {
		return "system/manager";
	}

	/**
	 * 拙笔一篇
	 * @return
	 */
	@RequestMapping("/content_manage.do")
	public String toContentManager() {
		return "system/content";
	}

	/**
	 * 文章列表
	 *
	 * @return
	 */
	@RequestMapping("/article_list.do")
	public String toContentList() {
		return "system/content_list";
	}


	@RequestMapping("/unauthorized")
	public String toUnauthorizedPage() {
		return "system/unauthorized";
	}

	/**
	 * 留言管理
	 *
	 * @return
	 */
	@RequestMapping("bbs_list.do")
	public String toBbsList() {
		return "system/bbs_list";
	}

}
