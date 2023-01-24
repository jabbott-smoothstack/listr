package com.jabbott.listr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jabbott.listr.dto.NewUserDto;
import com.jabbott.listr.dto.UserLoginDto;
import com.jabbott.listr.model.User;
import com.jabbott.listr.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/api/user/login")
	public ResponseEntity<User> userLogin(@RequestBody UserLoginDto userLoginDto) {
		
	}
	
	@PostMapping(value = "/api/user/")
	public ResponseEntity<User> createNewUser(@RequestBody NewUserDto newUserDto) {
		
	}
	
	@GetMapping(value = "/api/user/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		
	}
}