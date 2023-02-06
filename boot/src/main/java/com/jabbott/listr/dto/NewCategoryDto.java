package com.jabbott.listr.dto;

public class NewCategoryDto {
	
	private Long listId;
	private String categoryName;

	public Long getListId() {
		return listId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setListId(Long id) {
		listId = id;
	}
	
	public void setCategoryName(String name) {
		categoryName = name;
	}
	
}