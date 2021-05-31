package com.example.scrumtracker.controller;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author erdemcemozer
 */

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public boolean createUser(@RequestBody Users user) {

		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		user.setId(id);

		System.out.println("Logger : User controller create.");
		if (!ObjectUtils.isEmpty(user)) {
			return userService.createUser(user);
		} else {
			return false;
		}

	}

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

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<Users> getAllUsers() {

		System.out.println("Logger : Listing all users");

		List<Users> usersList = userService.getAllUsers();
		return usersList;

	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public Users getUser(@RequestBody Users user) {

		System.out.println("Logger : Listing chosen user");

		return userService.getUser(user);

	}

}
