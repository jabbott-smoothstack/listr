package com.jabbott.listr.model;

public class User {
	private Long user_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password_hash;
	
	public User() {
		user_id = 0L;
	}
	
	public void setUserId(Long userId) {
		user_id = userId;
	}
	
	public void setFirstName(String firstName) {
		first_name = firstName;
	}
	
	public void setLastName(String lastName) {
		last_name = lastName;
	}
	
	public void setEmail(String eMail) {
		email = eMail;
	}
	
	public void setPasswordHash(String passwordHash) {
		password_hash = passwordHash;
	}
	
	public Long getUserId() {
		return user_id;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPasswordHash() {
		return password_hash;
	}
}
