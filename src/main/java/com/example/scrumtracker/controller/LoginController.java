package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.LoginService;
import com.example.scrumtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Users> login(@RequestBody Users user) {

		System.out.println("Logger : Login controller create.");

		if (!ObjectUtils.isEmpty(user)) {
			loginService.login(getUser(user.getEmail(), user.getPassword()));
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
