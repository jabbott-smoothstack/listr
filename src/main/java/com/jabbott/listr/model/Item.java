package com.jabbott.listr.model;

public class Item {
	private Long item_id;
	private String item_name;
	private Long item_category_id;
	
	public Item() {
		item_id = 0L;
	}
	
	public void setItemId(Long itemId) {
		item_id = itemId;
	}
	
	public void setItemName(String itemName) {
		item_name = itemName;
	}
	
	public void setItemCategoryId(Long itemCategoryId) {
		item_category_id = itemCategoryId;
	}
	
	public Long getItemId() {
		return item_id;
	}
	
	public String getItemName() {
		return item_name;
	}
	
	public Long getItemCategoryId() {
		return item_category_id;
	}
}
