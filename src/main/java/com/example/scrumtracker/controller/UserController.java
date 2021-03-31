package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

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

		user.setId("123"); // just for test, but we need to change id's to string

		System.out.println("Testt");
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

		System.out.println("Updateeee");
		if (!ObjectUtils.isEmpty(user)) {
			userService.updateUser(user, user.getUsername(), user.getPassword());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	// Giving id and user parameters at the same time looks kinda unnecessary. Will
	// discuss it later.
	@RequestMapping(value = "/deleteUser" , method = RequestMethod.POST)
	public ResponseEntity<Users> deleteUser(@RequestBody Users user) {

		System.out.println("DLT");
		if (!ObjectUtils.isEmpty(user)) {
			userService.deleteUser(user, user.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
