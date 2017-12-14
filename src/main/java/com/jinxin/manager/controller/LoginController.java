package com.jinxin.manager.controller;

import com.jinxin.manager.po.User;
import com.jinxin.manager.service.UserService;
import com.jinxin.manager.util.ShiroKit;
import com.jinxin.manager.vo.LoginUser;
import com.jinxin.manager.vo.ResponseEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private UserService userService;

	/**
	 * 请求登录
	 *
	 * @param request
	 * @param loginUser
	 * @return
	 */
	@RequestMapping(value = "/user_login.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> loginSys(HttpServletRequest request, LoginUser loginUser) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>();
		LOGGER.info("login name: {}; pwd: {};code:{}", loginUser.getName(), loginUser.getPassword(), loginUser.getCode());
		String code = (String) SecurityUtils.getSubject().getSession().getAttribute("code");
		if (!loginUser.getCode().equals(code)) {
			responseEntity.setResult("codeerror");
			return responseEntity;
		}
		User user = userService.queryUserByName(loginUser.getName());
		//无此用户
		if (user == null) {
			responseEntity.setResult("usererror");
			return responseEntity;
		}
		String pwd = ShiroKit.md5(loginUser.getPassword(), user.getSalt());
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getName(), pwd);
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			responseEntity.setResult("usererror");
			return responseEntity;
		}
		responseEntity.setResult("success");
		return responseEntity;
	}


}
