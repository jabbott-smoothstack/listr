package com.jabbott.listr.controller;

import java.util.HashMap;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.jabbott.listr.model.User;
import com.jabbott.listr.dto.UserInfoDto;
import com.jabbott.listr.dto.UserLoginDto;
import com.jabbott.listr.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/api/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		return new ResponseEntity<User>(userService.findUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/user/email/")
	public ResponseEntity<UserInfoDto> getUserInfoByEmail(@RequestBody HashMap<String, String> userInfo) {
		User user = userService.findUserByEmail(userInfo.get("email"));
		UserInfoDto userInfoDto = new UserInfoDto();
		userInfoDto.setFirstName(user.getFirstName());
		userInfoDto.setUserId(user.getUserId());
		return new ResponseEntity<UserInfoDto>(userInfoDto, HttpStatus.OK);
	}

	@PostMapping(value = "/api/user/login/")
	public ModelAndView userLogin(@Valid @ModelAttribute("userLogin") UserLoginDto userLogin, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("listspage");
		ModelAndView errorView = new ModelAndView("error");
		
		if(userLogin.getEmail() == "" || userLogin.getPassword() == "") {
			return errorView;
		}
		
		User toLogin = userService.findUserByEmail(userLogin.getEmail());
		
		if(toLogin == null) {
			return errorView;
		}
	
		if(toLogin.getPasswordHash().compareTo(userLogin.getPassword()) == 0) {
			response.addCookie(new Cookie("user", userLogin.getEmail()));
			return view;
		}
		
		return errorView;
			
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
