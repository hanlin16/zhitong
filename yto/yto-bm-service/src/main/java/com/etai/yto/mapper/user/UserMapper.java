package com.etai.yto.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.user.User;
import com.etai.yto.page.user.UserPage;

public interface UserMapper {
	
	/**
	 * 分页查询用户信息
	 */
	@SelectProvider(method="queryUserPage", type=UserProvider.class)
	public List<User> queryUserPage(UserPage page);

	/**
	 * 查询用户总条数
	 */
	@SelectProvider(method="queryUserCount", type=UserProvider.class)
	public int queryUserCount(UserPage page);

	/**
	 * 获取用户信息
	 */
	@SelectProvider(method="getUserById", type=UserProvider.class)
	public User getUserById(Integer userId);

	/**
	 * 用户编辑
	 */
	@UpdateProvider(method="userEditById", type=UserProvider.class)
	public void userEditById(User user);

	/**
	 * 根据用户名获取用户信息
	 */
	@SelectProvider(method="getUserByLoginName", type=UserProvider.class)
	public User getUserByLoginName(String loginName);

	/**
	 * 添加用户
	 */
	@InsertProvider(method="userAdd", type=UserProvider.class)
	public void userAdd(User user);

	/**
	 * 删除用户
	 */
	@Delete(" delete from t_sys_user where id=#{userId}")
	public void userDelete(@Param("userId") Integer userId);

	@Select("select count(1) from t_sys_user where manager = 1 and status = 1 and id !=#{userId}")
	public int checkAvailableAdminCount(Integer userId);

	@UpdateProvider(method="userUpPwd", type=UserProvider.class)
	public int userUpPwd(@Param("userId") String userId, @Param("oldPasswd") String oldPasswd, @Param("newPasswd") String newPasswd);
}
