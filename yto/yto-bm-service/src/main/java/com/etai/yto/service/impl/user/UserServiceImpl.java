package com.etai.yto.service.impl.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.UserService;
import com.etai.yto.manager.UserManager;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.user.UserPage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserManager userManager;
	
	//邮件发送配置
	@Value("${usermessage.code}")
	private String messageCode;
	@Value("${messageUrl}")
	private String messageUrl;
	@Value("${message_environment}")
  	private String environment;
	
	/**
	 * 分页查询用户数据
	 */
	@Override
	public RemoteResult<PageResult<User>> queryUserPage(@RequestBody UserPage page) {
		RemoteResult<PageResult<User>> result = new RemoteResult<PageResult<User>>();
		PageResult<User> pageResult = new PageResult<User>();
		try {
			if(StringUtils.isNotBlank(page.getUserName())) {
				page.setUserName("%"+page.getUserName()+"%");
			}
			int count = userManager.queryUserCount(page);
			List<User> list = new ArrayList<>();
			if(count>0) {
				if(page.getLimit()!=null) {
					page.setRows(page.getLimit());
				}
				page.setRowCount(count);
				list = userManager.queryUserPage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("用户管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 根据用户Id获取用户数据
	 */
	@Override
	public RemoteResult<User> getUserById(@RequestParam("userId") Integer userId) {
		RemoteResult<User> result = new RemoteResult<>();
		try {
			User user = userManager.getUserById(userId);
			result.setSuccess(true);
			result.setData(user);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("用户管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 编辑用户信息
	 */
	@Override
	public RemoteResult<User> userEditById(@RequestBody User user) {
		RemoteResult<User> result = new RemoteResult<>();
		if(user.getId()==null) {
			result.setErrorMsg("用户Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			User userCheck = userManager.getUserById(user.getId());
			if(userCheck!=null ) {
				//如果是管理员，做唯一的管理员无法更新撤销逻辑
				Integer manager = userCheck.getManager();
				if(manager!=null && manager==1) {
					int managerCount = userManager.checkAvailableAdminCount(user.getId());
					if(managerCount>0) {
						return updateUserCheckLoginName(user, result);
					}else {
						if(0==user.getStatus()) {
							result.setSuccess(false);
							result.setErrorMsg("当前系统唯一有效的管理员不能置为无效");
							return result;
						}
						if(0==user.getManager()) {
							result.setSuccess(false);
							result.setErrorMsg("当前系统唯一有效的管理员不能更改角色");
							return result;
						}
						return updateUserCheckLoginName(user, result);
					}
				}else { //普通用户更改
					return updateUserCheckLoginName(user, result);
				}
			}else {
				result.setErrorMsg("该用户不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("用户数据更新请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 更新用户信息，并检查用户名
	 */
	private RemoteResult<User> updateUserCheckLoginName(User user, RemoteResult<User> result) {
		User userDb = userManager.getUserByLoginName(user.getLoginName());
		if(userDb!=null && userDb.getId()!=user.getId()) {
			result.setErrorMsg("用户登录名已存在！");
			result.setSuccess(false);
			return result;
		}
		userManager.userEditById(user);
		result.setSuccess(true);
		return result;
	}

	/**
	 * 用户添加
	 */
	@Override
	public RemoteResult<User> userAdd(@RequestBody User user) {
		RemoteResult<User> result = new RemoteResult<>();
		String loginName = user.getLoginName();
		if(StringUtils.isBlank(loginName)) {
			result.setErrorMsg("用户名不能为空！");
			result.setSuccess(false);
			return result;
		}
		User userDb = userManager.getUserByLoginName(loginName);
		if(userDb!=null) {
			result.setErrorMsg("登录用户名已存在！");
			result.setSuccess(false);
			return result;
		}
		try {
			userManager.userAdd(user);
//			try {
//				String mailHtml = "你的登录名："+user.getLoginName()+"<br/>密码："+user.getPassword()+"<br/>请妥善保管个人信息<br/>注：此为系统邮件，请勿直接回复";
//				List<String> mailReceivers = new ArrayList<String>();
//				mailReceivers.add(user.getEmail());
//				SendMailUtil.sendBuinessInfo("易通用户注册通知【"+environment+"】", mailHtml, messageCode, messageUrl, mailReceivers);
//			} catch (Exception e) {
//				logger.error(SendMailUtil.printStackTraceToString(e));
//			}
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("用户添加错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 用户删除
	 */
	@Override
	public RemoteResult<User> userDelete(@RequestParam("userId") Integer userId) {
		RemoteResult<User> result = new RemoteResult<>();
		if(userId==null) {
			result.setErrorMsg("用户Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			//查询删除用户是不是管理员
			User user = userManager.getUserById(userId);
			if(user!=null ) {
				//如果是管理员，做唯一的管理员无法删除逻辑
				Integer manager = user.getManager();
				if(manager!=null && manager==1) {
					int managerCount = userManager.checkAvailableAdminCount(userId);
					if(managerCount>0) {
						userManager.userDelete(userId);
						result.setSuccess(true);
						return result;
					}else {
						result.setSuccess(false);
						result.setErrorMsg("无法删除系统唯一有效的管理员！");
						return result;
					}
				}else {
					userManager.userDelete(userId);
					result.setSuccess(true);
					return result;
				}
			}else {
				result.setErrorMsg("该用户不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("用户删除错误！");
			result.setSuccess(false);
			return result;
		}
	}

	@Override
	public RemoteResult<User> userUpPwd(@RequestParam("userId")String userId, 
			@RequestParam("oldPasswd")String oldPasswd, @RequestParam("newPasswd")String newPasswd) {
		RemoteResult<User> result = new RemoteResult<>();
		if(userId==null) {
			result.setErrorMsg("用户Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		int userUpPwd = userManager.userUpPwd(userId, oldPasswd, newPasswd);
		if(userUpPwd>0) {
			result.setSuccess(true);
			return result;
		}else {
			result.setErrorMsg("请确认旧密码填写正确");
			result.setSuccess(false);
			return result;
		}
	}
	
}
