package com.jinxin.manager.dao.customer;

import com.jinxin.manager.dao.base.UserMapper;
import com.jinxin.manager.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yzy on 2017/08/23 下午 2:49.
 * email: mia5121@163.com
 */
public interface UserDao extends UserMapper {
	/**
	 * 用户总数
	 *
	 * @return
	 */
	int queryTotalUsers();

	/**
	 * 查询分页用户信息
	 *
	 * @param start
	 * @param rows
	 * @return
	 */
	List<User> queryPageUsers(@Param("start") int start, @Param("rows") int rows);

}
