package com.jinxin.manager.service;

import com.jinxin.manager.dao.customer.ArticleDao;
import com.jinxin.manager.po.BlogArticle;
import com.jinxin.manager.util.ConvertUtils;
import com.jinxin.manager.vo.BlogArticleVo;
import com.jinxin.manager.vo.BussinessException;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveOneArticle(BlogArticle articleBlog) {
		if (StringUtils.isBlank(articleBlog.getTitle())) {
			throw new BussinessException("标题不能为空");
		}
		if (StringUtils.isBlank(articleBlog.getSummary())) {
			throw new BussinessException("摘要不能为空");
		}
		String blog = ConvertUtils.escapeHtml(articleBlog.getArticle());
		articleBlog.setArticle(blog);
		articleBlog.setCreattime(new Date());
		articleBlog.setUpdatetime(new Date());
		articleDao.insertSelective(articleBlog);
	}

	@Override
	public PageInfo<List<BlogArticleVo>> listArticles(RequestPage page) {
		PageInfo<List<BlogArticleVo>> pageInfo = new PageInfo<>();
		int total = articleDao.queryTotalArticle();
		List<BlogArticle> blogArticles = articleDao.queryPageArticles(page.getStart(), page.getRows());
		if (CollectionUtils.isNotEmpty(blogArticles)) {
			List<BlogArticleVo> blogArticleVos = ConvertUtils.copyPropertiesList(BlogArticleVo.class, blogArticles);
			pageInfo.setRows(blogArticleVos);
		}
		pageInfo.setTotal(total);
		return pageInfo;
	}

	@Override
	public void delArticle(Integer articleId) {
		if (articleId == null) {
			LOGGER.warn("del article, article id is null");
			return;
		}
		BlogArticle article = articleDao.selectByPrimaryKey(articleId);
		if (article == null) {
			LOGGER.warn("db article id:{}  is null", articleId);
			return;
		}
		try {
			articleDao.deleteByPrimaryKey(articleId);
		} catch (Exception e) {
			throw new BussinessException("del article occur error");
		}
	}



}
