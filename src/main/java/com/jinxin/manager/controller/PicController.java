package com.jinxin.manager.controller;

import com.jinxin.manager.service.PicService;
import com.jinxin.manager.vo.ImgInfoVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yzy on 2017/08/10 下午 2:43.
 * email: mia5121@163.com
 * 图片接口
 */
@RequestMapping("/pic")
@Controller
public class PicController extends BaseController{

	@Autowired
	private PicService picService;

	/**
	 * 图片列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public PageInfo<List<ImgInfoVo>> listPics(HttpServletRequest request, RequestPage page){
		LOGGER.info("pic loading, {}, {} ....",page.getPage(),page.getRows());
		PageInfo<List<ImgInfoVo>> pageInfo = picService.queryAllPics();
		return pageInfo;
	}














}
