package com.jinxin.manager.po;

import java.util.Date;

public class BlogArticle {
	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.id
	 *
	 * @mbg.generated
	 */
	private Integer id;

    /**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.title
	 *
	 * @mbg.generated
	 */
	private String title;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.summary
	 *
	 * @mbg.generated
	 */
	private String summary;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.articletype
	 *
	 * @mbg.generated
	 */
	private Integer articleType;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.article
	 *
	 * @mbg.generated
	 */
	private String article;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.is_support
	 *
	 * @mbg.generated
	 */
	private Integer isSupport;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.is_secret
	 *
	 * @mbg.generated
	 */
	private Integer isSecret;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.creattime
	 *
	 * @mbg.generated
	 */
	private Date creattime;

	/**
	 *
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column t_my_blog.updatetime
	 *
	 * @mbg.generated
	 */
	private Date updatetime;

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.id
	 *
	 * @return the value of t_my_blog.id
	 *
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.id
	 *
	 * @param id the value for t_my_blog.id
	 *
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.title
	 *
	 * @return the value of t_my_blog.title
	 *
	 * @mbg.generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.title
	 *
	 * @param title the value for t_my_blog.title
	 *
	 * @mbg.generated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.summary
	 *
	 * @return the value of t_my_blog.summary
	 *
	 * @mbg.generated
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.summary
	 *
	 * @param summary the value for t_my_blog.summary
	 *
	 * @mbg.generated
	 */
	public void setSummary(String summary) {
		this.summary = summary == null ? null : summary.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.articletype
	 *
	 * @return the value of t_my_blog.articletype
	 *
	 * @mbg.generated
	 */
	public Integer getArticleType() {
		return articleType;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.articletype
	 *
	 * @param articleType the value for t_my_blog.articletype
	 *
	 * @mbg.generated
	 */
	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.article
	 *
	 * @return the value of t_my_blog.article
	 *
	 * @mbg.generated
	 */
	public String getArticle() {
		return article;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.article
	 *
	 * @param article the value for t_my_blog.article
	 *
	 * @mbg.generated
	 */
	public void setArticle(String article) {
		this.article = article == null ? null : article.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.is_support
	 *
	 * @return the value of t_my_blog.is_support
	 *
	 * @mbg.generated
	 */
	public Integer getIsSupport() {
		return isSupport;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.is_support
	 *
	 * @param isSupport the value for t_my_blog.is_support
	 *
	 * @mbg.generated
	 */
	public void setIsSupport(Integer isSupport) {
		this.isSupport = isSupport;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.is_secret
	 *
	 * @return the value of t_my_blog.is_secret
	 *
	 * @mbg.generated
	 */
	public Integer getIsSecret() {
		return isSecret;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.is_secret
	 *
	 * @param isSecret the value for t_my_blog.is_secret
	 *
	 * @mbg.generated
	 */
	public void setIsSecret(Integer isSecret) {
		this.isSecret = isSecret;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.creattime
	 *
	 * @return the value of t_my_blog.creattime
	 *
	 * @mbg.generated
	 */
	public Date getCreattime() {
		return creattime;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.creattime
	 *
	 * @param creattime the value for t_my_blog.creattime
	 *
	 * @mbg.generated
	 */
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column t_my_blog.updatetime
	 *
	 * @return the value of t_my_blog.updatetime
	 *
	 * @mbg.generated
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column t_my_blog.updatetime
	 *
	 * @param updatetime the value for t_my_blog.updatetime
	 *
	 * @mbg.generated
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}