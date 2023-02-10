package com.jabbott.listr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jabbott.listr.dto.NewListDto;
import com.jabbott.listr.dto.UpdateListDto;
import com.jabbott.listr.model.List;
import com.jabbott.listr.service.ListService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class ListController {
	
	@Autowired
	private ListService listService;
	
	@GetMapping(value = "/api/list/all/{userId}")
	public ResponseEntity<java.util.List<List>> getListsByUserId(@PathVariable Long userId) {
		return new ResponseEntity<java.util.List<List>>(listService.getListsByUserId(userId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/list/")
	public ResponseEntity<List> createNewList(@RequestBody NewListDto newListDto) {
		return new ResponseEntity<List>(listService.createNewList(newListDto), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/api/list/")
	public ResponseEntity<List> updateList(@RequestBody UpdateListDto updateListDto) {
		return new ResponseEntity<List>(listService.updateList(updateListDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/api/list/{listId}")
	public ResponseEntity<List> deleteList(@PathVariable Long listId) {
		return new ResponseEntity<List>(listService.deleteList(listId), HttpStatus.OK);
	}
}