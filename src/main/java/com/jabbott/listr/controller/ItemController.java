package com.jabbott.listr.controller;

import java.util.List;

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

import com.jabbott.listr.dto.ItemDto;
import com.jabbott.listr.dto.UpdateItemDto;
import com.jabbott.listr.model.Item;
import com.jabbott.listr.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "/api/item/{categoryId}")
	public ResponseEntity<List<Item>> getItemsByCategoryId(@PathVariable Long categoryId) {
		return new ResponseEntity<List<Item>>(itemService.findItemsByCategoryId(categoryId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/item/")
	public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDto) {
		return new ResponseEntity<Item>(itemService.createItem(itemDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/api/item/{itemId}")
	public ResponseEntity<Item> deleteItem(@PathVariable Long itemId) {
		return new ResponseEntity<Item>(itemService.deleteItem(itemId), HttpStatus.OK);
	}
	
	@PutMapping(value = "/api/item/")
	public ResponseEntity<Item> updateItem(@RequestBody UpdateItemDto updateItemDto) {
		return new ResponseEntity<Item>(itemService.updateItem(updateItemDto), HttpStatus.OK);
	}
}
