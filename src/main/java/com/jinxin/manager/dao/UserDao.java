package com.jinxin.manager.dao;

import com.jinxin.manager.dao.base.UserMapper;
import com.jinxin.manager.po.User;

/**
 * Created by yzy on 2017/08/23 下午 2:49.
 * email: mia5121@163.com
 */
public interface UserDao extends UserMapper {

	void addUser(User user);


}
