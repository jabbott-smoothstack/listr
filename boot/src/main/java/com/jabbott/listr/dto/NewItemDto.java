package com.jabbott.listr.dto;

public class NewItemDto {
	
	private Long itemCategoryId;
	private String newItemName;

	public String getItemName() {
		return newItemName;
	}
	
	public Long getItemCategoryId() {
		return itemCategoryId;
	}
	
	public void setItemCategoryId(Long id) {
		itemCategoryId = id;
	}
	
	public void setNewItemName(String name) {
		newItemName = name;
	}
	
} 