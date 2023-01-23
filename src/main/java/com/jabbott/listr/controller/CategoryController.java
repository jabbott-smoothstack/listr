package com.jabbott.listr.controller;

import java.util.HashMap;
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

import com.jabbott.listr.dto.CategoryDto;
import com.jabbott.listr.dto.UpdateCategoryDto;
import com.jabbott.listr.model.Category;
import com.jabbott.listr.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/api/category/{listId}")
	public ResponseEntity<List<Category>> getCategoriesByListId(@PathVariable Long listId) {
		return new ResponseEntity<List<Category>>(categoryService.findCategoryByListId(listId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/category/")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto newCategoryInfo) {
		return new ResponseEntity<Category>(categoryService.createCategory(newCategoryInfo), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/api/category/{categoryId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Long categoryId) {
		return new ResponseEntity<Category>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
	}
	
	@PutMapping(value = "/api/category/")
	public ResponseEntity<Category> updateCategory(@RequestBody UpdateCategoryDto updateCategoryDto) {
		return new ResponseEntity<Category>(categoryService.updateCategory(updateCategoryDto), HttpStatus.OK);
	}
}
