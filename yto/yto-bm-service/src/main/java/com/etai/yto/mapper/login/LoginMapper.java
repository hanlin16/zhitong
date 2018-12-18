package com.etai.yto.mapper.login;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.etai.yto.model.user.User;

public interface LoginMapper {

	/**
	 * 用户登录
	 */
	@Select("select user_name, id, login_name, manager, status from t_sys_user "
			+ " where login_name=#{loginName} and password=#{password}")
	User userLogin(@Param("loginName")String loginName,@Param("password") String password);

	
	/**
	 * 更新登录时间
	 */
	@Update("update t_sys_user set last_login_time=#{lastLoginTime}  where id=#{id}")
	void updateLoginTime(User user);	

}
