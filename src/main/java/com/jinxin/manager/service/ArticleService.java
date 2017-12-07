package com.jinxin.manager.service;

import com.jinxin.manager.po.BlogArticle;
import com.jinxin.manager.vo.BlogArticleVo;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;

import java.util.List;

/**
 * Created by yezhangyuan on 2017-12-05.
 *
 * @author yezhangyuan
 *         <p>
 *         文章接口
 */
public interface ArticleService {
	/**
	 * 保存文章
	 *
	 * @param articleBlog
	 */
	void saveOneArticle(BlogArticle articleBlog);

	/**
	 * 分页查询文章
	 *
	 * @param page
	 * @return
	 */
	PageInfo<List<BlogArticleVo>> listArticles(RequestPage page);

	/**
	 * 删除文章
	 *
	 * @param articleId
	 */
	void delArticle(Integer articleId);

}
