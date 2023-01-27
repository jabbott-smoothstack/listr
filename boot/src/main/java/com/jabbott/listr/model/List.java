package com.jabbott.listr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list")
public class List {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "list_id")
	private Long listId;
	
	@Column(name = "list_name")
	private String listName;
	
	@Column(name = "list_user_id")
	private Long listUserId;

	public void setListName(String name) {
		listName = name;
	}
	
	public void setListUserId(Long id) {
		listUserId = id;
	}
	
	public void setListId(Long id) {
		listId = id;
	}
	
	public Long getListId() {
		return listId;
	}
	
	public String getListName() {
		return listName;
	}
	
	public Long getListUserId() {
		return listUserId;
	}
	
}