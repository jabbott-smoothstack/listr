package com.jabbott.listr.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/api/user/login")
	public ResponseEntity<User> userLogin(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
		User user = userService.getUserByEmail(userLoginDto.getEmail());
		if(user != null && user.getPassword().compareTo(userLoginDto.getPasswordHash()) == 0) {
			response.addCookie(new Cookie("user", user.getEmail()));
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
	}
	
	@PostMapping(value = "/api/user/")
	public ResponseEntity<User> createNewUser(@RequestBody NewUserDto newUserDto) {
		return new ResponseEntity<User>(userService.createUser(newUserDto), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/api/user/email")
	public ResponseEntity<User> getUserByEmail(@RequestBody HashMap<String, String> email) {
		return new ResponseEntity<User>(userService.getUserByEmail(email.get("email")), HttpStatus.OK);
	}
}