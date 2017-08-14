package com.jinxin.manager.enumkit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yzy on 2017/08/14 上午 11:16.
 * email: mia5121@163.com
 */
public enum PicType {
	LUN_PO_PIC(1, "首页轮播图"),
	PRO_PIC(2, "产品图"),
	NEWS_PIC(3, "新闻图");

	private int i;
	private String type;

	PicType(int i, String type) {
		this.i = i;
		this.type = type;
	}

	private static final Map<Integer, PicType> map = new HashMap<>();

	static {
		for (PicType p : values()) {
			map.put(p.intValue(), p);
		}
	}

	public int intValue() {
		return i;
	}

	public String getType() {
		return type;
	}


}
