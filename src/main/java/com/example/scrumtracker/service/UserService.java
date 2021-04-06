package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;

import java.util.List;

/**
 * @author erdemcemozer
 */
public interface UserService {

	public void createUser(Users user);

	public void updateUser(Users user);

	public void deleteUser(Users user);

	public List<Users> getAllUsers();
}
