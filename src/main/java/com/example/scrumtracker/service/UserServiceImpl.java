package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.repository.UserMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public void updateUser(Users user) {

		if (userMongoDao.existsById(user.getId())) {
			// Setting new username and password
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			user.setEmail(user.getEmail());
			user.setTeam(user.getTeam());

			userMongoDao.save(user);
		} else {
			System.out.println("Nerede lan bu herif.");
		}

	}

	@Override
	public void deleteUser(Users user) {

		if (userMongoDao.existsById(user.getId())) {
			// Deleting user by id
			userMongoDao.deleteById(user.getId());
		} else {
			System.out.println("Bu eleman burada yok.");
		}
	}

	@Override
	public List<Users> getAllUsers() {
		return userMongoDao.findAll();
	}
}
