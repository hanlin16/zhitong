package com.etai.yto.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.login.LoginMapper;
import com.etai.yto.model.user.User;

@Component
public class LoginManager {

	@Autowired
	LoginMapper loginMapper;

	/**
	 * 根据用户名，密码获取用户
	 */
	public User userLogin(String loginName, String password) {
		return loginMapper.userLogin(loginName, password);
	}

	/**
	 * 更新上一次登录时间
	 */
	@Transactional(rollbackFor=Exception.class)
	public void updateLoginTime(User user) {
		loginMapper.updateLoginTime(user);
	}	
}
