package com.jinxin.manager.service;

import com.jinxin.manager.dao.customer.UserDao;
import com.jinxin.manager.po.User;
import com.jinxin.manager.po.UserExample;
import com.jinxin.manager.util.ConvertUtils;
import com.jinxin.manager.vo.BussinessException;
import com.jinxin.manager.vo.PageInfo;
import com.jinxin.manager.vo.RequestPage;
import com.jinxin.manager.vo.UserVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by yzy on 2017/08/23 下午 2:48.
 * email: mia5121@163.com
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;


	@Override
	@Transactional(rollbackFor = {})
	public void addUser(UserVo userVo) {
		userVo.setCreatetime(new Date());
		userVo.setUpdatetime(new Date());
		userDao.insertSelective(userVo);
	}

	@Override
	public PageInfo<List<UserVo>> queryPageUses(RequestPage requestPage) {
		PageInfo pageInfo = new PageInfo();
		int start = requestPage.getStart();
		int rows = requestPage.getRows();
		int total = userDao.queryTotalUsers();
		List<User> userList = userDao.queryPageUsers(start, rows);
		List<UserVo> userVos = ConvertUtils.copyPropertiesList(UserVo.class, userList);
		pageInfo.setTotal(total);
		pageInfo.setRows(userVos);
		return pageInfo;
	}

	@Override
	public void delUser(Integer userId) {
		if (userId == null) {
			LOGGER.warn("del user,user is null");
			return;
		}
		User user = userDao.selectByPrimaryKey(userId);
		if (user == null) {
			LOGGER.warn("db user is null");
			return;
		}
		try {
			userDao.deleteByPrimaryKey(userId);
		} catch (Exception e) {
			throw new BussinessException("del user occur error");
		}
		return;
	}

	@Override
	public User queryUserByName(String name) {
		if (StringUtils.isBlank(name)) {
			LOGGER.info("query user by name, name is blank");
			return null;
		}
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);
		List<User> users = userDao.selectByExample(example);
		if (CollectionUtils.isNotEmpty(users)) {
			return users.get(0);
		}
		return null;
	}

}
