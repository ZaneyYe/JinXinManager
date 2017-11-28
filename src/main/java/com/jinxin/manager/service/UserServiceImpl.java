package com.jinxin.manager.service;

import com.jinxin.manager.dao.UserDao;
import com.jinxin.manager.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by yzy on 2017/08/23 下午 2:48.
 * email: mia5121@163.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	@Override
	@Transactional(rollbackFor = {})
	public void addUser(UserVo userVo) {
		userVo.setCreatetime(new Date());
		userVo.setUpdatetime(new Date());
		userDao.insert(userVo);
	}


}
