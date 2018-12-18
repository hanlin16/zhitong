package com.etai.yto.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.user.User;
import com.etai.yto.page.RemoteResult;

public interface LoginService {

	@PostMapping("login")
	RemoteResult<User> userLogin(@RequestParam("loginName")String loginName,@RequestParam("password") String password);

	@PostMapping("logout")
	RemoteResult<User> updateLoginTime(User user);

}
