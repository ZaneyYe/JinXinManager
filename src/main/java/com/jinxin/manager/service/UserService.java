package com.jinxin.manager.service;

import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.UserVo;

/**
 * Created by yzy on 2017/08/23 下午 2:46.
 * email: mia5121@163.com
 */
public interface UserService {
	/**
	 * 增加用户
	 *
	 * @param userVo
	 */
	void addUser(UserVo userVo);

	/**
	 * 分页查询用户
	 *
	 * @param requestPage
	 * @return
	 */
	PageInfo queryPageUses(RequestPage requestPage);
}
