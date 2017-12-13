package com.jinxin.manager.realm;

import com.jinxin.manager.po.User;
import com.jinxin.manager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yezhangyuan on 2017-12-13.
 *
 * @author yezhangyuan
 */
public class UserDbRealm extends AuthenticatingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = userService.queryUserByName(token.getPrincipal().toString());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
		}
		return null;
	}
}
