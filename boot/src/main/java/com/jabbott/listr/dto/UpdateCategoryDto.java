package com.jabbott.listr.dto;

public class UpdateCategoryDto {
	
	private Long categoryId;
	private String newCategoryName;

	public Long getCategoryId() {
		return categoryId;
	}
	
	public String getNewCategoryName() {
		return newCategoryName;
	}
	
	public void setCategoryId(Long id) {
		categoryId = id;
	}
	
	public void setNewCategoryName(String name) {
		newCategoryName = name;
	}
	
}