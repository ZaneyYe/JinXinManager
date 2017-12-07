package com.jinxin.manager.enumkit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yezhangyuan on 2017-12-05.
 *
 * @author yezhangyuan
 */
public enum ArticleType {
	技术(1, "技术"),
	生活(2, "生活");

	private Integer id;
	private String name;

	ArticleType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	private static final Map<Integer, ArticleType> map = new HashMap<>();

	static {
		for (ArticleType type : values()) {
			map.put(type.intValue(), type);
		}
	}

	public Integer intValue() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static List<ArticleType> getAllEnum() {
		return Arrays.asList(values());
	}

	public static ArticleType getTypeByid(Integer id) {
		return map.get(id) == null ? null : map.get(id);
	}


}
