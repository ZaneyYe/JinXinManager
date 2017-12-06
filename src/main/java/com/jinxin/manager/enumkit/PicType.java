package com.jinxin.manager.enumkit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yzy on 2017/08/14 上午 11:16.
 * email: mia5121@163.com
 */
public enum PicType {
	LUN_PO_PIC(1, "首页轮播图"),
	PRO_PIC(2, "产品图"),
	NEWS_PIC(3, "新闻图"),
	BLOG_PIC(4, "博客插图");

	private int id;
	private String name;

	PicType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private static final Map<Integer, PicType> map = new HashMap<>();

	static {
		for (PicType p : values()) {
			map.put(p.intValue(), p);
		}
	}

	public Integer intValue() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PicType getTypeById(Integer id) {
		return map.get(id) == null ? null : map.get(id);
	}

	public static List<PicType> getAllEnum() {
		return Arrays.asList(values());
	}


}
