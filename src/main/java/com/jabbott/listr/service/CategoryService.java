package com.jabbott.listr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.CategoryDao;
import com.jabbott.listr.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	// TODO Refactor this method
	public Category createCategory(Category newCategory) {
		if(categoryDao.findById(newCategory.getCategoryId()) == null) {
			return categoryDao.save(newCategory);
		}
		else return null;
	}
	
	public Category findCategoryById(Long categoryId) {
		return categoryDao.findById(categoryId);
	}
	
	public List<Category> findCategoriesByListId(Long listId) {
		return categoryDao.findAllByListId(listId);
	}
	
	public Category deleteListById(Long categoryId) {
		return categoryDao.deleteById(categoryId);
	}
}
