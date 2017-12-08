package com.jinxin.manager.util;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzy yezhangyuan on 2017/12/1
 * 转换工具
 *
 * @author yezhangyuan
 */
public class ConvertUtils {

	public static final Logger LOGGER = LoggerFactory.getLogger(ConvertUtils.class);

	/**
	 * 单转
	 *
	 * @param ori
	 * @param clazz
	 */
	public static <T> T convertObject(Object ori, Class<T> clazz) {
		try {
			T des = clazz.newInstance();
			BeanUtils.copyProperties(des, ori);
			return des;
		} catch (Exception e) {
			LOGGER.error("copeProperties error", e);
		}
		return null;
	}

	/**
	 * 转换指定类型的list
	 *
	 * @param c
	 * @param oriList 
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> copyPropertiesList(Class<T> c, List oriList) {
		if (oriList == null) {
			return null;
		}
		List<T> desList = new ArrayList<>(oriList.size());
		for (Object ori : oriList) {
			try {
				T des = c.newInstance();
				BeanUtils.copyProperties(des, ori);
				desList.add(des);
			} catch (Exception e) {
				LOGGER.error("copyPropertiesList error", e);
			}
		}
		return desList;
	}

	/**
	 * 防止sql注入工具
	 *
	 * @param content
	 * @return
	 */
	public static final String escapeHtml(String htmlContent) {
		/*if (StringUtils.isBlank(content)) {
			return "";
		}
		content = content.replace("<", "&#60;");
		content = content.replace(">", "&#62;");
		content = content.replace("\"", "&#34;");
		content = content.replace("'", "&#39;");
		content = content.replaceAll("&(?![\\w#]+;|#\\d+)", "&#38;");*/
		htmlContent = HtmlUtils.htmlEscape(htmlContent);
		return htmlContent;
	}

	/**
	 * 转码2html标签
	 *
	 * @param content
	 * @return
	 */
	public static final String convertHtml(String content) {
		return HtmlUtils.htmlUnescape(content);
	}


}
