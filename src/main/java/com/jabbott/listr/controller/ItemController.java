package com.jabbott.listr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jabbott.listr.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
}
