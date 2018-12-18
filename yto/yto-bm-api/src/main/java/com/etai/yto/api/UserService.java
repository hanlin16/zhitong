package com.etai.yto.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.user.UserPage;

public interface UserService {

	@RequestMapping(value = "/user/queryUserList", method = RequestMethod.POST)
	RemoteResult<PageResult<User>> queryUserPage(UserPage page);

	@GetMapping("/user/getUserById")
	RemoteResult<User> getUserById(@RequestParam("userId") Integer userId);

	@PostMapping("/user/userEdit")
	RemoteResult<User> userEditById(User user);

	@PostMapping("/user/userAdd")
	RemoteResult<User> userAdd(User user);

	@PostMapping("/user/userDelete")
	RemoteResult<User> userDelete(@RequestParam("userId")Integer userId);
	
	@PostMapping("/user/userUpdatePwd")
	RemoteResult<User> userUpPwd(@RequestParam("userId")String userId, 
			@RequestParam("oldPasswd")String oldPasswd, @RequestParam("newPasswd")String newPasswd);
	
}
