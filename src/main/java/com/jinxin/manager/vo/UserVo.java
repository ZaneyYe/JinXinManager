package com.jinxin.manager.vo;

import com.jinxin.manager.po.User;
import com.jinxin.manager.util.DateFormatUtil;

/**
 * Created by yzy on 2017/08/22 下午 4:30.
 * email: mia5121@163.com
 */
public class UserVo extends User {

	public String getUserSex() {
		if (getSex() != null) {
			return getSex() == 1 ? "男" : "女";
		}
		return "男";
	}

	public String getCreateTimeStr() {
		if (getCreatetime() != null) {
			return DateFormatUtil.dateToString(getCreatetime(), DateFormatUtil.DEFAULT_DATE_VIEW_DETAIL);
		}
		return "";
	}

}
