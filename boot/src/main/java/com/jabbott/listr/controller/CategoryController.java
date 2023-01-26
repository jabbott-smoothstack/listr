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

import com.jabbott.listr.dto.NewCategoryDto;
import com.jabbott.listr.dto.UpdateCategoryDto;
import com.jabbott.listr.model.Category;
import com.jabbott.listr.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/api/category/{listId}")
	public ResponseEntity<List<Category>> getCategoryByListId(@PathVariable Long listId) {
		return new ResponseEntity<List<Category>>(categoryService.getCategoriesByListId(listId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/category/")
	public ResponseEntity<Category> createCategory(@RequestBody NewCategoryDto newCategoryDto) {
		return new ResponseEntity<Category>(categoryService.createNewCategory(newCategoryDto), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/api/category/")
	public ResponseEntity<Category> updateCategory(@RequestBody UpdateCategoryDto updateCategoryDto) {
		return new ResponseEntity<Category>(categoryService.updateCategory(updateCategoryDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/api/category/{categoryId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Long categoryId) {
		return new ResponseEntity<Category>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
	}
	
}