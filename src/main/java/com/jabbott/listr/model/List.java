package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "list")
public class List {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long list_id;
	
	@NotNull
	@Column(name = "list_user_id")
	private Long list_user_id;
	
	@NotNull
	@Column(name = "list_name")
	private String list_name;
	
	public List() {
		
	}
	
	public void setListId(Long listId) {
		list_id = listId;
	}
	
	public void setListUserId(Long listUserId) {
		list_user_id = listUserId;
	}
	
	public void setListName(String listName) {
		list_name = listName;
	}
	
	public Long getListId() {
		return list_id;
	}
	
	public Long getListUserId() {
		return list_user_id;
	}
	
	public String getListName() {
		return list_name;
	}
}
