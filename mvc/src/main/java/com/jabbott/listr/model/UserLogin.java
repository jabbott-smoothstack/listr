package com.jabbott.listr.model;

import javax.validation.constraints.NotNull;

public class UserLogin {
	
	@NotNull(message = "Please provide a valid email address.")
	private String email;
	
	@NotNull(message = "Password cannot be blank.")
	private String password;
	
	public UserLogin() {
		
	}
	
	public void setEmail(String _email) {
		email = _email;
	}
	
	public void setPassword(String _password) {
		password = _password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
