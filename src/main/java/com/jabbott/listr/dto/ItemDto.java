package com.jabbott.listr.dto;

import javax.validation.constraints.NotNull;

public class ItemDto {

	@NotNull(message = "Please provide an item name")
	private String itemName;
	
	@NotNull(message = "Please provide a category ID")
	private Long categoryId;
	
	public ItemDto() {
		
	}
	
	public void setItemName(String name) {
		itemName = name;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setCategoryId(Long id) {
		categoryId = id;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
}
