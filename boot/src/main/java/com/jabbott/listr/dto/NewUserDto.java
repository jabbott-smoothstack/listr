package com.jabbott.listr.dto;

public class NewUserDto {
	private String firstName;
	private String lastName;
	private String email;
	private String passwordHash;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setEmail(String userEmail) {
		email = userEmail;
	}
	
	public void setPassword(String password) {
		passwordHash = password;
	}
}