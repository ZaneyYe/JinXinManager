package com.jinxin.manager.controller;

import com.jinxin.manager.enumkit.StateInfo;
import com.jinxin.manager.po.BlogArticle;
import com.jinxin.manager.service.ArticleService;
import com.jinxin.manager.util.ConvertUtils;
import com.jinxin.manager.util.DateFormatUtil;
import com.jinxin.manager.vo.BlogArticleVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.ResponseEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

	@RequestMapping(value = "/saveArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StateInfo> saveArticle(HttpServletRequest request, BlogArticle articleBlog) {
		ResponseEntity entity = new ResponseEntity();
		LOGGER.info("begin  saveArticle,title:....{}", articleBlog.getTitle());
		articleService.saveOneArticle(articleBlog);
		entity.setResult(StateInfo.SUCCESS);
		return entity;
	}

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<List<BlogArticleVo>> listArticles(HttpServletRequest request, RequestPage page) {
		LOGGER.info("begin listArticle,page:....{}..{}", page.getPage(), page.getRows());
		PageInfo<List<BlogArticleVo>> pageInfo = articleService.listArticles(page);
		return pageInfo;
	}

	@RequestMapping(value = "delArticle.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> deleteArticle(HttpServletRequest request, Integer articleId) {
		LOGGER.info("begin delArticle:....{}", articleId);
		ResponseEntity entity = new ResponseEntity();
		articleService.delArticle(articleId);
		return entity;
	}

	@RequestMapping(value = "/queryArticle", method = RequestMethod.GET)
	public String queryArticle(@Param("articleId") String articleId, Map<String, Object> dataMap) {
		LOGGER.info("query article, id:{}", articleId);
		if (StringUtils.isBlank(articleId)) {
			LOGGER.warn("query article, articleId is null");
			return "system/prev_article";
		}
		BlogArticleVo blogArticleVo = articleService.queryArticle(Integer.valueOf(articleId));
		if (blogArticleVo != null) {
			String showArticle = ConvertUtils.convertHtml(blogArticleVo.getArticle());
			String localCreateTime = DateFormatUtil.dateToString(blogArticleVo.getCreattime(), DateFormatUtil.DEFAULT_SHOW_ART_TIME);
			dataMap.put("createTimeShow", localCreateTime);
			dataMap.put("title", blogArticleVo.getTitle());
			dataMap.put("summary", blogArticleVo.getSummary());
			dataMap.put("showArticle", showArticle);
		}
		return "system/prev_article";
	}


}
