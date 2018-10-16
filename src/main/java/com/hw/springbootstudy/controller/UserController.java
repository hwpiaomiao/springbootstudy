package com.hw.springbootstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hw.springbootstudy.common.ItdragonResult;
import com.hw.springbootstudy.common.ItdragonUtils;
import com.hw.springbootstudy.pojo.User;
import com.hw.springbootstudy.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/api/createUser", method = RequestMethod.GET)
	public ItdragonResult createUser()  {
		User user = new User();
		user.setAccount("gitLiu");
		user.setUserName("ITDragonGit");
		user.setEmail("itdragon@git.com");
		user.setIphone("12349857999");
		user.setPlainPassword("adminroot");
		user.setPlatform("github");
		user.setCreatedDate(ItdragonUtils.getCurrentDateTime());
		user.setUpdatedDate(ItdragonUtils.getCurrentDateTime());
		ItdragonUtils.entryptPassword(user);
		return userService.registerUser(user);
	}

}
