package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;

import java.util.List;

/**
 * @author erdemcemozer
 */
public interface UserService {

	public boolean createUser(Users user);

	public void updateUser(Users user);

	public void deleteUser(Users user);

	public List<Users> getAllUsers();

	Users getUser(Users user);
}
