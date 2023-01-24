package com.jabbott.listr.dto;

public class UpdateItemDto {

	private Long itemId;
	private String newItemName;
	
	public Long getItemId() {
		return itemId;
	}
	
	public String getItemName() {
		return newItemName;
	}
	
	public void setItemId(Long id) {
		itemId = id;
	}
	
	public void setItemName(String name) {
		newItemName = name;
	}
	
}