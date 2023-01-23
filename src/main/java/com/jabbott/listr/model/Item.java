package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long item_id;
	
	@NotNull
	@Column(name = "item_name")
	private String item_name;
	
	@NotNull
	@Column(name = "item_category_id")
	private Long item_category_id;
	
	public Item() {
		
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
