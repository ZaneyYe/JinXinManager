package com.jinxin.manager.controller;

import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.po.BlogArticle;
import com.jinxin.manager.service.ArticleService;
import com.jinxin.manager.vo.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yzy on 2017/12/5
 *
 * @author yezhangyuan
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "saveArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StateInfo> saveArticle(HttpServletRequest request, BlogArticle article) {
		ResponseEntity entity = new ResponseEntity();
		LOGGER.info("begin  saveArticle....");
		articleService.saveOneArticle(article);
		entity.setResult(StateInfo.SUCCESS);
		return entity;
	}
}
