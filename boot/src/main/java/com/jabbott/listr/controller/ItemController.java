package com.jabbott.listr.controller;

import java.util.List;

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

import com.jabbott.listr.dto.NewItemDto;
import com.jabbott.listr.dto.UpdateItemDto;
import com.jabbott.listr.model.Item;
import com.jabbott.listr.service.ItemService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/api/item/{categoryId}")
	public ResponseEntity<List<Item>> getItemsByCategoryId(@PathVariable Long categoryId) {
		return new ResponseEntity<List<Item>>(itemService.getItemsByCategoryId(categoryId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/item/")
	public ResponseEntity<Item> createNewItem(@RequestBody NewItemDto newItemDto) {
		return new ResponseEntity<Item>(itemService.createNewItem(newItemDto), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/api/item/")
	public ResponseEntity<Item> updateItem(@RequestBody UpdateItemDto updateItemDto) {
		return new ResponseEntity<Item>(itemService.updateItem(updateItemDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/api/item/{itemId}")
	public ResponseEntity<Item> deleteItem(@PathVariable Long itemId) {
		return new ResponseEntity<Item>(itemService.deleteItem(itemId), HttpStatus.OK);
	}
}