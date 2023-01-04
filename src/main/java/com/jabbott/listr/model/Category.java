package com.jabbott.listr.model;

public class Category {
	private Long category_id;
	private String category_name;
	private Long category_list_id;
	
	public Category() {
		category_id = 0L;
	}
	
	public void setCategoryId(Long categoryId) {
		category_id = categoryId;
	}
	
	public void setCategoryName(String categoryName) {
		category_name = categoryName;
	}
	
	public void setCategoryListId(Long categoryListId) {
		category_list_id = categoryListId;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryName() {
		return category_name;
	}
	
	public Long getCategoryListId() {
		return category_list_id;
	}
}
