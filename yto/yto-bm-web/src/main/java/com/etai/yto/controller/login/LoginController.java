package com.etai.yto.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.FeignLoginService;
import com.etai.yto.api.user.FeignUserService;
import com.etai.yto.model.user.User;
import com.etai.yto.page.RemoteResult;

@RestController
public class LoginController {
	
	@Autowired(required=false)
	FeignLoginService loginService;
	
	@Autowired(required=false)
	FeignUserService userService;
	
	@PostMapping("loginUserInfo")
	public RemoteResult<User> loginUserInfo(HttpSession session) {
		RemoteResult<User> result = new RemoteResult<>();
		User user = (User) session.getAttribute("currentUser");
		result.setData(user);
		result.setSuccess(true);
		return result;
	}	
	
	@PostMapping("login")
	public RemoteResult<User> login(String loginName, String password, HttpSession session) {
		RemoteResult<User> remoteResult = loginService.userLogin(loginName, password);
		if(remoteResult.isSuccess()) {
			User user = remoteResult.getData();
			if(user!=null) {
				loginService.updateLoginTime(user);
				session.setAttribute("currentUser", user);
				remoteResult.setData(null);
				return remoteResult;
			}
		}
		return remoteResult;
	}	
}
