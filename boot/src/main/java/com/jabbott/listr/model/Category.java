package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private Long categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_list_id")
	private Long categoryListId;

	public void setCategoryName(String newCategoryName) {
		categoryName = newCategoryName;
	}
	
	public void setCategoryId(Long id) {
		categoryId = id;
	}
	
	public void setCategoryListId(Long id) {
		categoryListId = id;
	}
	
	public Long getCategoryId() { 
		return categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public Long getCategoryListId() {
		return categoryListId;
	}
	
}