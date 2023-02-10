package com.jabbott.listr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jabbott.listr.dto.NewCategoryDto;
import com.jabbott.listr.dto.UpdateCategoryDto;
import com.jabbott.listr.model.Category;
import com.jabbott.listr.repository.CategoryRepository;
import com.jabbott.listr.service.CategoryService;

@ActiveProfiles("test")
@SpringBootTest(classes = {CategoryService.class, UnitTestConfiguration.class})
public class CategoryTests extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	//Positive Tests
	
	@Test
	public void createCategory() {
		Category newCategory = new Category();
		newCategory.setCategoryId(1L);
		newCategory.setCategoryName("Test Category");
		newCategory.setCategoryListId(1L);
		
		NewCategoryDto newCategoryDto = new NewCategoryDto();
		newCategoryDto.setCategoryName("Test Category");
		newCategoryDto.setListId(1L);
		
		Mockito.when(categoryRepository.save(newCategory)).thenReturn(newCategory);
		
		Category createdCategory = categoryService.createNewCategory(newCategoryDto);
		
		Assert.assertEquals(createdCategory.getCategoryListId(), newCategory.getCategoryListId());
		Assert.assertEquals(createdCategory.getCategoryName().compareTo(newCategory.getCategoryName()), 0);
	}
	
	@Test
	public void retrieveCategory() {
		Category categoryToRetrieve = new Category();
		categoryToRetrieve.setCategoryId(1L);
		categoryToRetrieve.setCategoryListId(1L);
		categoryToRetrieve.setCategoryName("Test Category");
		
		List<Category> retrievedCategories = new ArrayList<Category>();
		retrievedCategories.add(categoryToRetrieve);
		
		Mockito.when(categoryRepository.findCategoriesByCategoryListId(1L)).thenReturn(retrievedCategories);
		
		List<Category> retrievedCategoriesList = categoryService.getCategoriesByListId(1L);
		Category retrievedCategory = retrievedCategoriesList.get(0);
		
		Assert.assertEquals(retrievedCategory.getCategoryId(), categoryToRetrieve.getCategoryId());
		Assert.assertEquals(retrievedCategory.getCategoryListId(), categoryToRetrieve.getCategoryListId());
		Assert.assertEquals(retrievedCategory.getCategoryName().compareTo(categoryToRetrieve.getCategoryName()), 0);
	}
	
	@Test
	public void updateCategory() {
		Category categoryToUpdate = new Category();
		categoryToUpdate.setCategoryId(1L);
		categoryToUpdate.setCategoryListId(1L);
		categoryToUpdate.setCategoryName("Test Category Edited");
		
		UpdateCategoryDto updateCategoryDto = new UpdateCategoryDto();
		updateCategoryDto.setCategoryId(1L);
		updateCategoryDto.setNewCategoryName("Test Category Edited");
		
		Optional<Category> updatedCategoryOptional = Optional.of(categoryToUpdate);
		
		Mockito.when(categoryRepository.findById(1L)).thenReturn(updatedCategoryOptional);
		
		Category updatedCategory = categoryService.updateCategory(updateCategoryDto);
		
		Assert.assertEquals(updatedCategory.getCategoryId(), categoryToUpdate.getCategoryId());
		Assert.assertEquals(updatedCategory.getCategoryListId(), categoryToUpdate.getCategoryListId());
		Assert.assertEquals(updatedCategory.getCategoryName().compareTo(categoryToUpdate.getCategoryName()), 0);
	}
	
	@Test
	public void deleteCategory() {
		Category categoryToDelete = new Category();
		categoryToDelete.setCategoryId(1L);
		categoryToDelete.setCategoryListId(1L);
		categoryToDelete.setCategoryName("Test Category");
		
		Optional<Category> deletedCategoryOptional = Optional.of(categoryToDelete);
		
		Mockito.when(categoryRepository.findById(1L)).thenReturn(deletedCategoryOptional);
		
		Category deletedCategory = categoryService.deleteCategory(1L);
		
		Assert.assertEquals(categoryToDelete.getCategoryId(), deletedCategory.getCategoryId());
		Assert.assertEquals(categoryToDelete.getCategoryListId(), deletedCategory.getCategoryListId());
		Assert.assertEquals(categoryToDelete.getCategoryName().compareTo(deletedCategory.getCategoryName()), 0);
	}
	
	//Negative Tests
	
	@Test
	public void retrieveCategoryDoesNotExist() {
		Category categoryToRetrieve = new Category();
		categoryToRetrieve.setCategoryId(1L);
		categoryToRetrieve.setCategoryListId(1L);
		categoryToRetrieve.setCategoryName("Test Category");
		
		List<Category> retrievedCategories = new ArrayList<Category>();
		
		Mockito.when(categoryRepository.findCategoriesByCategoryListId(2L)).thenReturn(retrievedCategories);
		
		List<Category> retrievedCategoriesList = categoryService.getCategoriesByListId(2L);
		
		Assert.assertEquals(retrievedCategoriesList.size(), 0);
	}
	
	@Test
	public void updateCategoryDoesNotExist() {
		Category categoryToUpdate = new Category();
		categoryToUpdate.setCategoryId(1L);
		categoryToUpdate.setCategoryListId(1L);
		categoryToUpdate.setCategoryName("Test Category Edited");
		
		UpdateCategoryDto updateCategoryDto = new UpdateCategoryDto();
		updateCategoryDto.setCategoryId(2L);
		updateCategoryDto.setNewCategoryName("Test Category Edited");
		
		Optional<Category> updatedCategoryOptional = Optional.empty();
		
		Mockito.when(categoryRepository.findById(2L)).thenReturn(updatedCategoryOptional);
		
		Category updatedCategory = categoryService.updateCategory(updateCategoryDto);
		
		Assert.assertEquals(updatedCategory, null);
	}
	
	@Test
	public void deleteCategoryDoesNotExist() {
		Category categoryToDelete = new Category();
		categoryToDelete.setCategoryId(1L);
		categoryToDelete.setCategoryListId(1L);
		categoryToDelete.setCategoryName("Test Category");
		
		Optional<Category> deletedCategoryOptional = Optional.empty();
		
		Mockito.when(categoryRepository.findById(2L)).thenReturn(deletedCategoryOptional);
		
		Category deletedCategory = categoryService.deleteCategory(2L);
		
		Assert.assertEquals(deletedCategory, null);
	}
}
