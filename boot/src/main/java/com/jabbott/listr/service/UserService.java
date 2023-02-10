package com.jabbott.listr.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dto.NewUserDto;
import com.jabbott.listr.model.User;
import com.jabbott.listr.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User createUser(NewUserDto newUserDto) {
		User newUser = new User();
		newUser.setFirstName(newUserDto.getFirstName());
		newUser.setLastName(newUserDto.getLastName());
		newUser.setEmail(newUserDto.getEmail());
		newUser.setPassword(newUserDto.getPasswordHash());
		userRepository.save(newUser);
		return newUser;
	}

	public User getUserByEmail(String email) {
		Optional<User> retrievedUser = userRepository.findByEmail(email);
		if(retrievedUser.isPresent()) {
			User user = retrievedUser.get();
			return user;
		}
		else return null;
	}
	
}