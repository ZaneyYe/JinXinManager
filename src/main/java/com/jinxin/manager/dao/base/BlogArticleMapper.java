package com.jinxin.manager.dao.base;

import com.jinxin.manager.po.BlogArticle;
import com.jinxin.manager.po.BlogArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogArticleMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	long countByExample(BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int deleteByExample(BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int insert(BlogArticle record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int insertSelective(BlogArticle record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	List<BlogArticle> selectByExampleWithBLOBs(BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	List<BlogArticle> selectByExample(BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	BlogArticle selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int updateByExampleWithBLOBs(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(BlogArticle record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKeyWithBLOBs(BlogArticle record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table t_my_blog
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKey(BlogArticle record);
}