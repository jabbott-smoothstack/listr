package com.jabbott.listr.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import com.jabbott.listr.model.User;

@Service
public class UserService {
	
	public User createUser(HashMap<String, String> userData) {
		User user = new User();
		user.setEmail(userData.get("e"));
		user.setFirstName(userData.get("f"));
		user.setLastName(userData.get("l"));
		user.setPasswordHash(userData.get("p"));
		return user;
	}
}
