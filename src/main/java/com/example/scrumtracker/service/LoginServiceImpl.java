package com.example.scrumtracker.service;

import com.example.scrumtracker.model.Users;
import com.example.scrumtracker.repository.UserMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mkurfeyiz
 */

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMongoDao userMongoDao;

	@Autowired
	private UserService userService;

	List<String> passwords;
	List<String> emails;

	@Override
	public void login(Users user) {

		passwords = new ArrayList<>(userService.getAllUsers().size());
		getPasswords(passwords);

		emails = new ArrayList<>(userService.getAllUsers().size());
		getEmails(emails);

		String hashedPassword = passwords.get(passwords.indexOf(userMongoDao.findByEmail(user.getEmail()).getPassword()));

		if (emails.contains(user.getEmail())) {

			if (BCrypt.checkpw(user.getPassword(), hashedPassword)) {
				System.out.println("Logger : Log-in successfull");
				user.setLoginFlag(true);
				// redirect to another page
			} else {
				System.out.println("Logger : Log-in failed!");
				user.setLoginFlag(false);
			}
		}

	}

	public void getPasswords(List<String> passwords) {
		passwords.clear();
		for (int i = 0; i < userService.getAllUsers().size(); i++) {
			passwords.add(userService.getAllUsers().get(i).getPassword());
		}
	}

	public void getEmails(List<String> emails) {
		emails.clear();
		for (int i = 0; i < userService.getAllUsers().size(); i++) {
			emails.add(userService.getAllUsers().get(i).getEmail());
		}
	}
}
