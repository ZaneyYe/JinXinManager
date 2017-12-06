package com.jinxin.manager.dao.customer;

import com.jinxin.manager.dao.base.BlogArticleMapper;
import com.jinxin.manager.po.BlogArticle;
import org.apache.ibatis.annotations.Param;

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

}
