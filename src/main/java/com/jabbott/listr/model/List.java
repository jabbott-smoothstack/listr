package com.jabbott.listr.model;

public class List {
	private Long list_id;
	private Long list_user_id;
	private String list_name;
	
	public List() {
		list_id = 0L;
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
