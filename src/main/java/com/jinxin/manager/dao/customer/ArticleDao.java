package com.jinxin.manager.dao.customer;

import com.jinxin.manager.dao.base.BlogArticleMapper;
import com.jinxin.manager.po.BlogArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yezhangyuan on 2017-12-05.
 *
 * @author yezhangyuan
 */
public interface ArticleDao extends BlogArticleMapper {
	/**
	 * 插入文章
	 *
	 * @param article
	 */
	void insertArticle(@Param("articleBlog") BlogArticle article);

	/**
	 * 统计所有有效的文章数
	 *
	 * @return
	 */
	int queryTotalArticle();

	/**
	 * 分页查询文章
	 *
	 * @param start
	 * @param rows
	 * @return
	 */
	List<BlogArticle> queryPageArticles(@Param("start") Integer start, @Param("rows") Integer rows);
}
