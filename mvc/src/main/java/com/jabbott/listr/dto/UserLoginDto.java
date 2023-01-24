package com.jabbott.listr.dto;

import javax.validation.constraints.NotNull;

public class UserLoginDto {

	@NotNull(message = "Please provide an email address")
	private String email;
	
	@NotNull(message = "Please provide a password")
	private String password;
	
	public UserLoginDto() {
		
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public void setPassword(String p) {
		password = p;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
