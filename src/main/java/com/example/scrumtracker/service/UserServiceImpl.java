package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.repository.UserMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	}

	@Override
	public void updateUser(Users user, String newUsername, String newPassword) {

		if (userMongoDao.existsById(user.getId())) {
			// Setting new username and password
			user.setUsername(newUsername);
			user.setPassword(newPassword);

			userMongoDao.save(user);
		} else {
			System.out.println("Nerede lan bu herif.");
		}

	}

	@Override
	public void deleteUser(Users user, String id) {

		if (userMongoDao.existsById(user.getId())) {
			// Deleting user by id
			userMongoDao.deleteById(id);
		} else {
			System.out.println("Bu eleman burada yok.");
		}
	}
}
