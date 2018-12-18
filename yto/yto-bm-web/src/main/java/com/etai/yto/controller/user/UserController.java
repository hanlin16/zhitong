package com.etai.yto.controller.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.user.FeignUserService;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.user.UserPage;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	FeignUserService userService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 用户查询功能
	 */
	@PostMapping("/queryUserList")
	public PageResult<User> queryUserList(UserPage page) {
		PageResult<User> data = new PageResult<>();
		try {
			RemoteResult<PageResult<User>> remoteResult = userService.queryUserPage(page);
			if(remoteResult.isSuccess()) {
				data = remoteResult.getData();
				data.setState(true);
				return data;
			}else {
				data = remoteResult.getData();
				data.setState(false);
				data.setErrorMsg(remoteResult.getErrorMsg());
				return data;
			}
		} catch (Exception e) {
			logger.error("用户查询功能报错:",e);
			data.setState(false);
			data.setErrorMsg("用户查询功能报错:");
			return data;
		}
	}
	
	/**
	 * 用户添加
	 */
	@PostMapping("/userAdd")
	public RemoteResult<User> userAdd(User user){
		user.setStatus(1);
		RemoteResult<User> remoteResult = userService.userAdd(user);
		return remoteResult;
	}
	
	/**
	 * 修改密码
	 */
	@PostMapping("/userUpdatePwd")
	public RemoteResult<User> userUpPwd(String userId, String oldPassword, String newPassword){
		RemoteResult<User> remoteResult = userService.userUpPwd(userId, oldPassword, newPassword);
		return remoteResult;
	}
	
	/**
	 * 用户编辑
	 */
	@PostMapping("/userEdit")
	public RemoteResult<User> userEdit(User user){
		RemoteResult<User> remoteResult = userService.userEditById(user);
		return remoteResult;
	}
	
	/**
	 * 用户删除
	 */
	@PostMapping("/userDelete")
	public RemoteResult<User> userDelete(Integer userId, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		if(user!=null && userId.equals(user.getId())) {
			RemoteResult<User> remoteResult = new RemoteResult<User>();
			remoteResult.setErrorMsg("在线用户不能删除自己");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
		RemoteResult<User> remoteResult = userService.userDelete(userId);
		return remoteResult;
	}
	
}
