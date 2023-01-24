package com.jabbott.listr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dto.NewCategoryDto;
import com.jabbott.listr.dto.UpdateCategoryDto;
import com.jabbott.listr.model.Category;
import com.jabbott.listr.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategoriesByListId(Long id) {
		return categoryRepository.findCategoriesByListId(id);
	}

	public Category createNewCategory(NewCategoryDto newCategoryDto) {
		Category newCategory = new Category();
		newCategory.setCategoryListId(newCategoryDto.getListId());
		newCategory.setCategoryName(newCategoryDto.getCategoryName());
		categoryRepository.save(newCategory);
		return newCategory;
	}

	public Category updateCategory(UpdateCategoryDto updateCategoryDto) {
		Optional<Category> toUpdate = categoryRepository.findById(updateCategoryDto.getCategoryId());
		if(toUpdate.isPresent()) {
			Category category = toUpdate.get();
			category.setCategoryName(updateCategoryDto.getNewCategoryName());
			categoryRepository.save(category);
			return category;
		}
		else return null;
	}

	public Category deleteCategory(Long categoryId) {
		Optional<Category> toDelete = categoryRepository.findById(categoryId);
		if(toDelete.isPresent()) {
			Category category = toDelete.get();
			categoryRepository.deleteById(categoryId);
			return category;
		}
		else return null;
	}
	
}