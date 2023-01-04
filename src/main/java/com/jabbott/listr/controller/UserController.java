package com.jabbott.listr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jabbott.listr.model.User;

@RestController
public class UserController {

	@GetMapping(value = "/api/user/{userId}")
	public ResponseEntity<User> getUserById(Long userId) {
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/user/")
	public ResponseEntity<User> createNewUser() {
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
}
