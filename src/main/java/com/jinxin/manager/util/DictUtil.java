package com.jinxin.manager.util;

import com.jinxin.manager.enumkit.ArticleType;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by yezhangyuan on 2017-12-05.
 * 字典工具
 *
 * @author yezhangyuan
 */
public class DictUtil {

	private static final String dictBasePackage = "com.jinxin.manager.enumkit";

	public static <T> List<T> getData(String className) {
		return getDataByMethod(className, "getAllEnum");
	}

	/**
	 * 非全路径
	 *
	 * @param className
	 * @param methodName
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> getDataByMethod(String className, String methodName) {
		String completeClassName = dictBasePackage + "." + className;
		return getDataByCompleteClassName(completeClassName, methodName);
	}

	/**
	 * 全路径
	 *
	 * @param completeClassName
	 * @param methodName
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> getDataByCompleteClassName(String completeClassName, String methodName) {
		Object dictList = null;
		try {
			Class<T> clazz = (Class<T>) Class.forName(completeClassName);
			Method[] methods = clazz.getDeclaredMethods();
			if (StringUtils.isBlank(methodName)) {
				methodName = "getAllEnum";
			}
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					try {
						dictList = method.invoke(null, null);
						break;
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dictList == null ? null : (List<T>) dictList;
	}

	public static void main(String[] args) {
		List<ArticleType> articleTypes = DictUtil.getData("ArticleType");
		System.out.println(articleTypes.get(0).getName());
	}
}
