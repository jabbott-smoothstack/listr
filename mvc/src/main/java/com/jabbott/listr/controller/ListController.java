package com.jabbott.listr.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jabbott.listr.dto.UpdateListDto;
import com.jabbott.listr.model.List;
import com.jabbott.listr.service.ListService;

@Controller
public class ListController {
	
	@Autowired
	private ListService listService;

	@GetMapping(value = "/api/list/{listId}")
	public ResponseEntity<List> getListById(@PathVariable Long listId) {
		return new ResponseEntity<List>(listService.findById(listId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/list/all/{userId}")
	public ResponseEntity<java.util.List<List>> getListsByUserId(@PathVariable Long userId) {
		return new ResponseEntity<java.util.List<List>>(listService.findAllByUserId(userId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/list/")
	public ResponseEntity<List> createNewList(@RequestBody HashMap<String, String> listInfo) {
		return new ResponseEntity<List>(listService.createList(listInfo), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/api/list/{listId}")
	public ResponseEntity<List> deleteList(@PathVariable Long listId) {
		return new ResponseEntity<List>(listService.deleteList(listId), HttpStatus.OK);
	}
	
	@PutMapping(value = "/api/list/")
	public ResponseEntity<List> updateList(@RequestBody UpdateListDto updateListDto) {
		return new ResponseEntity<List>(listService.updateList(updateListDto), HttpStatus.OK);
	}
	
}
