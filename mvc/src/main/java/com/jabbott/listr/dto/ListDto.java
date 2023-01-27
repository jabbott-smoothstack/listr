package com.jabbott.listr.dto;

import javax.validation.constraints.NotNull;

public class ListDto {

	@NotNull(message = "Please provide a list name")
	private String list_name;
	
	public ListDto() {
		
	}
	
	public void setListName(String name) {
		list_name = name;
	}
	
	public String getListName() {
		return list_name;
	}
}
