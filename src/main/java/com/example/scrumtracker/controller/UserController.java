package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author erdemcemozer
 */

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Users> createUser(@RequestBody Users user) {

		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		user.setId(id);

		System.out.println("Logger : User controller create.");
		if (!ObjectUtils.isEmpty(user)) {
			userService.createUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	// Overloading for different number of data's that will change.
	// Will discuss it later.
	// username,password
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<Users> updateUser(@RequestBody Users user) {

		System.out.println("Logger : User controller update.");
		if (!ObjectUtils.isEmpty(user)) {
			userService.updateUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ResponseEntity<Users> deleteUser(@RequestBody Users user) {

		System.out.println("Logger : User controller delete.");
		if (!ObjectUtils.isEmpty(user)) {
			userService.deleteUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
