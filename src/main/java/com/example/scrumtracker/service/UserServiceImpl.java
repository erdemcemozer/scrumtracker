package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.repository.UserMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erdemcemozer
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMongoDao userMongoDao;
	List<String> emails;
	List<String> phones;

	@Override
	public void createUser(Users user) {

		emails = new ArrayList<>(getAllUsers().size());
		getEmails(emails);
		phones = new ArrayList<>(getAllUsers().size());
		getPhones(phones);

		if (!emails.contains(user.getEmail()) && !phones.contains(user.getPhone())) {
			// encrypt/decrypt operations should be here
			user.setSignUpFlag(true);
			user.setLoginFlag(true);
			user.setPassword(encodePassword(user));
			userMongoDao.save(user);
		} else {
			user.setSignUpFlag(false);
			user.setLoginFlag(false);
			System.out.println("Logger : Phone number or Email address already exists!");
		}
	}

	@Override
	public void updateUser(Users user) {

		// Deleted the updated users email/phone values from list so that they cant have
		// the same email/phone with other users.
		emails = new ArrayList<>(getAllUsers().size());
		getEmails(emails);
		emails.remove(emails.indexOf(userMongoDao.findById(user.getId()).get().getEmail()));

		phones = new ArrayList<>(getAllUsers().size());
		getPhones(phones);
		phones.remove(phones.indexOf(userMongoDao.findById(user.getId()).get().getPhone()));

		if (userMongoDao.existsById(user.getId())) {
			if (!emails.contains(user.getEmail()) && !phones.contains(user.getPhone())) {
				// Setting new values
				user.setName(user.getName());
				user.setSurname(user.getSurname());
				// Setting encrypted password
				user.setPassword(encodePassword(user));
				user.setPhone(user.getPhone());
				user.setEmail(user.getEmail());
				user.setTeam(user.getTeam());

				userMongoDao.save(user);
			} else {
				System.out.println("Logger : Update cancelled!");
			}

		} else {
			System.out.println("Logger : Update cancelled!");
		}

	}

	@Override
	public void deleteUser(Users user) {

		if (userMongoDao.existsById(user.getId())) {
			// Deleting user by id
			userMongoDao.deleteById(user.getId());
		} else {
			System.out.println("Logger : User not found!");
		}
	}

	@Override
	public List<Users> getAllUsers() {
		return userMongoDao.findAll();
	}

	public String encodePassword(Users user) {

		String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// System.out.println(password);

		return password;
	}

	public void getEmails(List<String> emails) {
		emails.clear();
		for (int i = 0; i < getAllUsers().size(); i++) {
			emails.add(getAllUsers().get(i).getEmail());
		}
	}

	public void getPhones(List<String> phones) {
		phones.clear();
		for (int i = 0; i < getAllUsers().size(); i++) {
			phones.add(getAllUsers().get(i).getPhone());
		}
	}

}
