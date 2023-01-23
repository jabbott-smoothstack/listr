package com.jabbott.listr.service;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.UserDao;
import com.jabbott.listr.model.User;

@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User createUser(HashMap<String, String> userData) {
		User user = new User();
		user.setEmail(userData.get("e"));
		user.setFirstName(userData.get("f"));
		user.setLastName(userData.get("l"));
		user.setPasswordHash(userData.get("p"));
		
		userDao.save(user);
		
		return user;
	}
	
	public User findUserById(Long id) {
		return userDao.findById(id);
	}
	
	public User findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}
}
