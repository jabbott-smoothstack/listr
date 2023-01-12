package com.jabbott.listr.dao;

import com.jabbott.listr.model.User;

public class UserDao implements Dao<User> {

	private String firstName;
	private String email;
	
	@Override
	public UserDao convertFromModel(User model) {
		this.firstName = model.getFirstName();
		this.email = model.getEmail();
		return this;
	}
	
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getEmail() {
		return email;
	}

	
	

}
