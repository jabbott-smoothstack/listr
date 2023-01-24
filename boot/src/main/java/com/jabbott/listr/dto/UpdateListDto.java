package com.jabbott.listr.dto;

public class UpdateListDto {

	private Long listId;
	private String newListName;
	
	public Long getListId() {
		return listId;
	}
	
	public String getNewListName() {
		return newListName;
	}
	
	public void setListId(Long id) {
		listId = id;
	}
	
	public void setNewListName(String name) {
		newListName = name;
	}
	
}