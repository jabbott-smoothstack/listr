package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_category_id")
	private Long itemCategoryId;

	public void setItemName(String name) {
		itemName = name;
	}
	
	public void setItemId(Long id) {
		itemId = id;
	}
	
	public void setItemCategoryId(Long id) {
		itemCategoryId = id;
	}
	
	public Long getItemId() {
		return itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public Long getItemCategoryId() {
		return itemCategoryId;
	}
	
}