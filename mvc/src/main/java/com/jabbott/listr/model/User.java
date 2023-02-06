package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
	
	@NotNull
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "password_hash")
	private String password_hash;
	
	public User() {
		
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
