package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erdemcemozer
 */

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Users> createUser(@RequestBody Users user) {

		System.out.println("Testt");
		if (!ObjectUtils.isEmpty(user)) {
			userService.createUser(user);
			System.out.println("test user controller"); // TODO delete these later
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
