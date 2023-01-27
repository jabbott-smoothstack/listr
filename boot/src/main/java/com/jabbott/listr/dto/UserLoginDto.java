package com.jabbott.listr.dto;

public class UserLoginDto {
	private String email;
	private String passwordHash;
	
	public String getEmail() {
		return email;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public void setEmail(String userEmail) {
		email = userEmail;
	}
	
	public void setPassword(String password) {
		passwordHash = password;
	}
}