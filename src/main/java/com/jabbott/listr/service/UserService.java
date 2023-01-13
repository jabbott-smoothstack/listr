package com.jabbott.listr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jabbott.listr.dao.UserDao;
import com.jabbott.listr.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User createUser(User newUser) {
		if(userDao.findById(newUser.getUserId()) == null) {
			return userDao.save(newUser);
		}
		
		return null;
	}
	
	public User findUserByEmailAddress(String email) {
		return userDao.findUserByEmail(email);
	}
	
	public User getUserById(Long id) {
		return userDao.findById(id);
	}
	
	public User deleteUserById(Long id) {
		return userDao.deleteById(id);
	}
	
	public String authorizeUser(User userInfo) {
		User userToCheck = userDao.findById(userInfo.getUserId());
		if(userInfo.getPasswordHash() == userToCheck.getPasswordHash()) {
			return "authorized";
		}
		return "unauthorized";
	}
	
	public User getUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}
}
