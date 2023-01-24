package com.jabbott.listr.dto;

public class UpdateListDto {
	private Long listId;
	private String newListName;
	
	public UpdateListDto() {
		
	}
	
	public void setListId(Long id) {
		listId = id;
	}
	
	public void setNewListName(String name) {
		newListName = name;
	}
	
	public Long getListId() {
		return listId;
	}
	
	public String getNewListName() {
		return newListName;
	}
}
