package com.jabbott.listr.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jabbott.listr.model.User;
import com.jabbott.listr.model.UserLogin;
import com.jabbott.listr.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/api/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@PostMapping(value = "/api/user/login")
	public ModelAndView userLogin(@Valid @ModelAttribute("userLogin") UserLogin userLogin) {
		ModelAndView view = new ModelAndView("listspage");
		ModelAndView errorView = new ModelAndView("error");
		
		if(userLogin.getEmail() == "" | userLogin.getPassword() == "") {
			return errorView;
		}
		else {
			return view;
		}
	}

	@PostMapping(value = "/api/user/")
	public ResponseEntity<User> createNewUser(@RequestBody HashMap<String, String> newUserInfo) {
		if (newUserInfo.get("e") == "" || newUserInfo.get("f") == "" || newUserInfo.get("p") == "") {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			User newUser = userService.createUser(newUserInfo);
			return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		}

	}
}
