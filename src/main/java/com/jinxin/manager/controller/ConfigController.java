package com.jinxin.manager.controller;

import com.baidu.ueditor.ActionEnter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by yzy yezhangyuan on 2017/12/4 0004.
 *
 * @author yezhangyuan
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

	@RequestMapping(value = "/ueditor", method = RequestMethod.GET)
	@ResponseBody
	public String ueUpload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		String roolPath = request.getSession().getServletContext().getRealPath("/");
		//roolPath:E:\IdeaProjects\JinXinManager\target\JinXinManager\
		//String roolPath = ConfigController.class.getClassLoader().getResource("").getPath();
		LOGGER.info("roolPath:.......{}", roolPath);
		LOGGER.info("contextPath:..... {}", request.getContextPath());
		LOGGER.info("request uri:.....{}", request.getRequestURI());
		String configStr = new ActionEnter(request, roolPath).exec();
		return configStr;
	}


}
