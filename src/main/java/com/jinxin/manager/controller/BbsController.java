package com.jinxin.manager.controller;

import com.jinxin.manager.service.BbsService;
import com.jinxin.manager.vo.BbsMsgVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.ResponseEntity;
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
 * Created by yezhangyuan on 2018-04-17.
 *
 * @author yezhangyuan
 */
@Controller
@RequestMapping("/bbs")
public class BbsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BbsController.class);

	@Autowired
	private BbsService bbsService;

	@RequestMapping("/list.do")
	@ResponseBody
	public PageInfo<List<BbsMsgVo>> listBbsContent(HttpServletRequest request, RequestPage page) {
		LOGGER.info("begin list bbs content,page:{},rows:{}", page.getPage(), page.getRows());
		PageInfo<List<BbsMsgVo>> pageInfo = bbsService.listBbsContent(page);
		return pageInfo;
	}

	@RequestMapping(value = "/delBbsContent.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> delBbsContent(String bbsId) {
		LOGGER.info("begin del bbs content,bbsId:{}", bbsId);
		ResponseEntity<Void> entity = new ResponseEntity<>();
		bbsService.delBbsContent(bbsId);
		return entity;
	}



}
