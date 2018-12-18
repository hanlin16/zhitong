package com.etai.yto.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.LoginService;
import com.etai.yto.manager.LoginManager;
import com.etai.yto.manager.UserManager;
import com.etai.yto.model.user.User;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class LoginServiceImpl implements LoginService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoginManager loginManager;
	
	@Autowired
	UserManager userManager;
	
	/**
	 * 用户登录功能
	 */
	@Override
	public RemoteResult<User> userLogin(String loginName, String password) {
		RemoteResult<User> remoteResult = new RemoteResult<User>();
		try {
			User user = loginManager.userLogin(loginName, password);
			if(user==null) {
				remoteResult.setSuccess(false);
				remoteResult.setErrorMsg("用户名或密码错误");
				return remoteResult;
			}else {
				Integer userId = user.getId();
				if(userId==null){
					remoteResult.setSuccess(false);
					remoteResult.setErrorMsg("用户名或密码错误");
					return remoteResult;
				}else{
					//禁用账户无法登录系统
					Integer status = user.getStatus();
					if(status==0) {
						remoteResult.setSuccess(false);
						remoteResult.setErrorMsg("用户当前禁用，请联系管理员！");
						return remoteResult;
					}
					remoteResult.setSuccess(true);
					remoteResult.setData(user);
					return remoteResult;
				}
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			remoteResult.setErrorMsg("用户登录请求错误！");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
	}

	/**
	 * 更新登录时间
	 */
	@Override
	public RemoteResult<User> updateLoginTime(@RequestBody User user) {
		RemoteResult<User> remoteResult = new RemoteResult<User>();
		try {
			user.setLastLoginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			loginManager.updateLoginTime(user);
			remoteResult.setSuccess(true);
			return remoteResult;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			remoteResult.setErrorMsg("用户更新登录数据错误！");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
	}
	
}
