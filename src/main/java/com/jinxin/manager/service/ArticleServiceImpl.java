package com.jinxin.manager.service;

import com.jinxin.manager.dao.customer.ArticleDao;
import com.jinxin.manager.po.BlogArticle;
import com.jinxin.manager.util.ConvertUtils;
import com.jinxin.manager.vo.BussinessException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by yezhangyuan on 2017-12-05.
 *
 * @author yezhangyuan
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private ArticleDao articleDao;

	@Override
	public void saveOneArticle(BlogArticle article) {
		if (StringUtils.isBlank(article.getTitle())) {
			throw new BussinessException("标题不能为空");
		}
		if (StringUtils.isBlank(article.getSummary())) {
			throw new BussinessException("摘要不能为空");
		}
		String content = ConvertUtils.escapeHtml(article.getArticle());
		if (StringUtils.isNotBlank(content)) {
			article.setArticle(content);
		}
		article.setCreattime(new Date());
		article.setUpdatetime(new Date());
		articleDao.insertSelective(article);
	}


}
