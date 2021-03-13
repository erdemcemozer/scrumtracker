package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.repository.UserMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author erdemcemozer
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMongoDao userMongoDao;

	@Override
	public void createUser(Users user) {
		userMongoDao.save(user);
		System.out.println("test user service impl"); // TODO delete these later
	}
}
