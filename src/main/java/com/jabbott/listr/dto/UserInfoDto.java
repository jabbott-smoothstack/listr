package com.jabbott.listr.dto;

public class UserInfoDto {
	
	private Long userId;
	private String firstName;
	
	public UserInfoDto() {
		
	}
	
	public void setUserId(Long id) {
		userId = id;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
}
