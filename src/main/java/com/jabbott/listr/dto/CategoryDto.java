package com.jabbott.listr.dto;

import javax.validation.constraints.NotNull;

public class CategoryDto {

	@NotNull(message = "Please provide a category name")
	private String categoryName;
	
	@NotNull(message = "Please provide a category list ID")
	private Long categoryListId;
	
	public CategoryDto() {
		
	}
	
	public void setCategoryName(String name) {
		categoryName = name;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryListId(Long id) {
		categoryListId = id;
	}
	
	public Long getCategoryListId() {
		return categoryListId;
	}
}
