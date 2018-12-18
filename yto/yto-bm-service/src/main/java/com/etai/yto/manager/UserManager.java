package com.etai.yto.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.user.UserMapper;
import com.etai.yto.model.user.User;
import com.etai.yto.page.user.UserPage;

@Component("userManager")
public class UserManager {

	@Resource
	private UserMapper userMapper;
	
	public List<User> queryUserPage(UserPage page){
		List<User>  list = userMapper.queryUserPage(page);
		return list;
	}
	
	/**
	 * 查询用户总条数
	 */
	public int queryUserCount(UserPage page) {
		return userMapper.queryUserCount(page);
	}

	/**
	 * 根据用户Id获取用户信息
	 */
	public User getUserById(Integer userId) {
		return userMapper.getUserById(userId);
	}

	/**
	 * 根据用户Id编辑用户
	 */
	@Transactional(rollbackFor=Exception.class)
	public void userEditById(User user) {
		userMapper.userEditById(user);
	}

	/**
	 * 根据登录名获取用户
	 */
	public User getUserByLoginName(String loginName) {
		return userMapper.getUserByLoginName(loginName);
	}

	/**
	 * 用户添加
	 */
	@Transactional(rollbackFor=Exception.class)
	public void userAdd(User user) {
		userMapper.userAdd(user);
	}

	/**
	 * 用户删除
	 */
	@Transactional(rollbackFor=Exception.class)
	public void userDelete(Integer userId) {
		userMapper.userDelete(userId);
	}

	/**
	 * 查询可用的管理员总条数
	 * @param userId 
	 */
	public int checkAvailableAdminCount(Integer userId) {
		return userMapper.checkAvailableAdminCount(userId);
	}

	@Transactional(rollbackFor=Exception.class)
	public int userUpPwd(String userId, String oldPasswd, String newPasswd) {
		return userMapper.userUpPwd(userId, oldPasswd, newPasswd);
	}

}
