package com.jinxin.manager.controller;

import com.jinxin.manager.po.ImgInfo;
import com.jinxin.manager.service.PicService;
import com.jinxin.manager.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/08/10 下午 2:43.
 * email: mia5121@163.com
 * 图片接口
 */
@Controller
@RequestMapping("/pic")
public class PicController {

	@Autowired
	private PicService picService;

	/**
	 * 图片列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.do",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<ImgInfo> listPics(HttpServletRequest request){
		PageInfo<ImgInfo> pageInfo = picService.queryAllPics();
		return pageInfo;
	}









}
