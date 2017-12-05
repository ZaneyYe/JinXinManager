package com.jinxin.manager.service;

import com.jinxin.manager.po.BlogArticle;

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
	 * @param article
	 */
	void saveOneArticle(BlogArticle article);
}
