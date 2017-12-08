package com.jinxin.manager.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yzy on 2017/08/11 上午 11:12.
 * email: mia5121@163.com
 * 日期工具类
 */
public class DateFormatUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(DateFormatUtil.class);

	private DateFormatUtil(){}

	public static final String DEFAULT_DATE_VIEW = "yyyy-MM-dd";

	public static final String DEFAULT_DATE_VIEW_DETAIL = "yyyy-MM-dd hh:mm:ss";

	public static final String DEFAULT_SHOW_ART_TIME = "MMM d,yyyy";

	/**
	 * date2String 日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_VIEW);
		if(StringUtils.isNotBlank(format)){
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(date);
	}

	public static String dateToString(Date date){
		return  dateToString(date,null);
	}

	/**
	 * dateStr2Date 字符串转日期
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date strConvertDate(String dateStr,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_VIEW);
		if(StringUtils.isNotBlank(format)){
			sdf = new SimpleDateFormat(format);
		}
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("日期转换错误::"+dateStr);
		}
		return date;
	}
	public static Date strConvertDate(String dateStr){
		return strConvertDate(dateStr,null);
	}

	public static void main(String[] args){
		String s = dateToString(new Date());
		System.out.println(s);

		Date date = strConvertDate("2017-08-11");
		System.out.println(date);
	}
}
