package com.etai.yto.mapper.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.model.user.User;
import com.etai.yto.page.user.UserPage;

public class UserProvider extends BaseProvider{

	public String queryUserPage(UserPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id, user_name, phone_no, email, login_name, password, "
				+ " last_login_time, manager, status "
				+ " from t_sys_user where 1=1 ");
		if(StringUtils.isNotEmpty(page.getUserName())) {
			sb.append(" and user_name like #{userName}");
		}
		if(page.getStatus()!=null && page.getStatus()!=2) {
			sb.append(" and status=#{status}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	public String queryUserCount(UserPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from t_sys_user where 1=1 ");
		if(StringUtils.isNotEmpty(page.getUserName())) {
			sb.append(" and user_name like #{userName}");
		}
		if(page.getStatus()!=null && page.getStatus()!=2) {
			sb.append(" and status=#{status}");
		}
		return sb.toString();
	}	
	public String getUserById(Integer userId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id, user_name, phone_no, email, login_name, password, "
				+ " last_login_time, manager, status "
				+ " from t_sys_user where id =#{userId} ");
		return sb.toString();
	}
	
	public String userEditById(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_sys_user "
				+ " set user_name=#{userName}, phone_no = #{phoneNo}, "
				+ " email = #{email}, login_name=#{loginName}, password = #{password}, "
				+ " manager=#{manager}, status=#{status} "
				+ "  where id =#{id}  ");
		return sb.toString();
	}
	
	public String getUserByLoginName(String loginName) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id, user_name, phone_no, email, login_name, password, "
				+ " last_login_time, manager, status "
				+ " from t_sys_user where login_name =#{loginName} ");
		return sb.toString();
	}
	
	public String userAdd(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into t_sys_user("
				+ " user_name, phone_no, email, login_name, password, "
				+ " last_login_time, manager, status) "
				+ " values (#{userName}, #{phoneNo}, #{email}, #{loginName}, "
				+ " #{password}, #{lastLoginTime}, #{manager}, #{status}) ");
		return sb.toString();
	}
	
	public String userUpPwd(@Param("userId") String userId, @Param("oldPasswd") String oldPasswd, @Param("newPasswd") String newPasswd) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_sys_user "
				+ " set password=#{newPasswd} where id=#{userId} and password = #{oldPasswd} ");
		return sb.toString();
	}
}
