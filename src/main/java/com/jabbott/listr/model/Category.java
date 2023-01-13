package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	@NotNull
	@Column(name = "category_name")
	private String category_name;
	
	@NotNull
	@Column(name = "category_list_id")
	private Long category_list_id;
	
	public Category() {
		
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
		return category_id;
	}
	
	public String getCategoryName() {
		return category_name;
	}
	
	public Long getCategoryListId() {
		return category_list_id;
	}
}
