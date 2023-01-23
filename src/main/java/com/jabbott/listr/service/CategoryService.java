package com.jabbott.listr.service;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.CategoryDao;
import com.jabbott.listr.dto.CategoryDto;
import com.jabbott.listr.dto.UpdateCategoryDto;
import com.jabbott.listr.model.Category;

@Service("categoryService")
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public Category createCategory(CategoryDto newCategoryInfo) {
		Category newCategory = new Category();
		newCategory.setCategoryName(newCategoryInfo.getCategoryName());
		newCategory.setCategoryListId(newCategoryInfo.getCategoryListId());
		categoryDao.save(newCategory);
		return newCategory;
	}
	
	public Category findCategoryById(Long id) {
		return categoryDao.findById(id);
	}
	
	public List<Category> findCategoryByListId(Long id) {
		return categoryDao.findAllCategoriesByListId(id);
	}
	
	public Category deleteCategory(Long categoryId) {
		Category toDelete = findCategoryById(categoryId);
		categoryDao.delete(toDelete);
		return toDelete;
	}
	
	public Category updateCategory(UpdateCategoryDto updateCategoryDto) {
		categoryDao.editCategory(updateCategoryDto);
		return categoryDao.findById(updateCategoryDto.getCategoryId());
	}
}
