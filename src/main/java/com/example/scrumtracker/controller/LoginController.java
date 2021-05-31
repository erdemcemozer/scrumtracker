package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.LoginService;
import com.example.scrumtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mkurfeyiz
 */

@RestController
@RequestMapping(path = "/login-page")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(@RequestBody Users user) {

		System.out.println("Logger : Login controller create.");

		if (!ObjectUtils.isEmpty(user)) {
			return loginService.login(getUser(user.getEmail(), user.getPassword()));
		} else {
			return false;
		}
	}

	public Users getUser(String email, String password) {
		Users user = null;
		List<Users> usersList = userService.getAllUsers();

		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getEmail().equals(email)) {
				user = usersList.get(i);
			}
		}

		user.setPassword(password);

		return user;
	}

}
