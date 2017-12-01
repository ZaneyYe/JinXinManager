package com.jinxin.manager.controller;

import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.service.UserService;
import com.jinxin.manager.util.ShiroKit;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.ResponseEntity;
import com.jinxin.manager.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yzy on 2017/08/18 下午 3:51.
 * email: mia5121@163.com
 * 用户管理接口
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 增加用户
	 *
	 * @param request
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StateInfo> addUser(HttpServletRequest request,
											 UserVo userVo) {
		LOGGER.info("addUser,name::{}", userVo.getName());
		ResponseEntity<StateInfo> responseEntity = new ResponseEntity<>();
		//产生随机的盐值
		String randomSalt = ShiroKit.getRandomSalt(10);
		userVo.setSalt(randomSalt);
		//加密存入数据库
		userVo.setPassword(ShiroKit.md5(userVo.getPassword(), randomSalt));
		userService.addUser(userVo);
		responseEntity.setResult(StateInfo.SUCCESS);
		return responseEntity;
	}

	/**
	 * 分页查询
	 *
	 * @param request
	 * @param requestPage
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public PageInfo<List<UserVo>> listUser(HttpServletRequest request, RequestPage requestPage) {
		PageInfo pageInfo = null;
		LOGGER.info("query users, page:{}, rows:{}", requestPage.getPage(), requestPage.getRows());
		pageInfo = userService.queryPageUses(requestPage);
		return pageInfo;
	}


}
