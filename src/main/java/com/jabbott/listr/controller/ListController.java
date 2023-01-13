package com.jabbott.listr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jabbott.listr.model.List;
import com.jabbott.listr.service.ListService;

@RestController
public class ListController {

	@Autowired
	private ListService listService;
	
	@GetMapping(value = "/api/list/{userId}")
	public ResponseEntity<java.util.List<List>> getAllListsByUserId(@PathVariable Long userId) {
		return new ResponseEntity<java.util.List<List>>(listService.getListsByUserId(userId), HttpStatus.OK);
	}
	
	// TODO Refactor this method, maybe with a DTO?
	@PostMapping(value = "/api/list/")
	public ResponseEntity<List> createNewList(@RequestBody List list) {
		return new ResponseEntity<List>(listService.createList(list), HttpStatus.OK);
	}
}
