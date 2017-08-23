package com.jinxin.manager.controller;

import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.vo.ResponseEntity;
import com.jinxin.manager.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/08/18 下午 3:51.
 * email: mia5121@163.com
 * 用户管理接口
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StateInfo> addUser(HttpServletRequest request,
											 UserVo userVo) {
		LOGGER.info("增加用户...name::{}", userVo.getName());
		ResponseEntity<StateInfo> responseEntity = new ResponseEntity<>();
		responseEntity.setResult(StateInfo.SUCCESS);
		return responseEntity;
	}



}
