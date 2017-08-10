package com.jinxin.manager.controller;

import com.jinxin.manager.vo.LoginUser;
import com.jinxin.manager.vo.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/7/23.
 * email: mia5121@163.com
 */
@RequestMapping("/sys")
@Controller
public class LoginController extends BaseController {

	/**
	 * 请求登录
	 * @param request
	 * @param loginUser
	 * @return
	 */
	@RequestMapping(value = "/user_login.do",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> loginSys(HttpServletRequest request, LoginUser loginUser){
		ResponseEntity<String> responseEntity = new ResponseEntity<>();
		LOGGER.info("login name: {}; pwd: {}",loginUser.getName(),loginUser.getPassword());

		responseEntity.setResult("success");
		return  responseEntity;
	}


}
