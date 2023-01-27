package com.jabbott.listr.dto;

public class NewListDto {

	private Long userId;
	private String listName;
	
	public String getListName() {
		return listName;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long id) {
		userId = id;
	}
	
	public void setListName(String name) {
		listName = name;
	}
	
}