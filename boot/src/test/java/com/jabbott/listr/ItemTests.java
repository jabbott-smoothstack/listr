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

import com.jabbott.listr.dto.NewItemDto;
import com.jabbott.listr.dto.UpdateItemDto;
import com.jabbott.listr.model.Item;
import com.jabbott.listr.repository.ItemRepository;
import com.jabbott.listr.service.ItemService;

@ActiveProfiles("test")
@SpringBootTest(classes = {ItemService.class, UnitTestConfiguration.class})
public class ItemTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	//Positive Tests
	
	@Test
	public void createItem() {
		Item itemToCreate = new Item();
		itemToCreate.setItemCategoryId(1L);
		itemToCreate.setItemId(1L);
		itemToCreate.setItemName("Test Item");
		
		NewItemDto newItemDto = new NewItemDto();
		newItemDto.setItemCategoryId(1L);
		newItemDto.setNewItemName("Test Item");
		
		Mockito.when(itemRepository.save(itemToCreate)).thenReturn(itemToCreate);
		
		Item createdItem = itemService.createNewItem(newItemDto);
		
		Assert.assertEquals(itemToCreate.getItemCategoryId(), createdItem.getItemCategoryId());
		Assert.assertEquals(itemToCreate.getItemName().compareTo(createdItem.getItemName()), 0);
	}
	
	@Test
	public void retrieveItem() {
		Item itemToRetrieve = new Item();
		itemToRetrieve.setItemCategoryId(1L);
		itemToRetrieve.setItemId(1L);
		itemToRetrieve.setItemName("Test Item");
		
		List<Item> retrievedItemsList = new ArrayList<Item>();
		retrievedItemsList.add(itemToRetrieve);
		
		Mockito.when(itemRepository.findItemsByItemCategoryId(1L)).thenReturn(retrievedItemsList);
		
		List<Item> retrievedItems = itemService.getItemsByCategoryId(1L);
		Item retrievedItem = retrievedItems.get(0);
		
		Assert.assertEquals(retrievedItem.getItemCategoryId(), itemToRetrieve.getItemCategoryId());
		Assert.assertEquals(retrievedItem.getItemId(), itemToRetrieve.getItemId());
		Assert.assertEquals(retrievedItem.getItemName().compareTo(itemToRetrieve.getItemName()), 0);
	}
	
	@Test
	public void updateItem() {
		Item itemToUpdate = new Item();
		itemToUpdate.setItemCategoryId(1L);
		itemToUpdate.setItemId(1L);
		itemToUpdate.setItemName("Test Item Edited");
		
		UpdateItemDto updateItemDto = new UpdateItemDto();
		updateItemDto.setItemId(1L);
		updateItemDto.setNewItemName("Test Item Edited");
		
		Optional<Item> itemOptional = Optional.of(itemToUpdate);
		
		Mockito.when(itemRepository.findById(1L)).thenReturn(itemOptional);
		
		Item updatedItem = itemService.updateItem(updateItemDto);
		
		Assert.assertEquals(itemToUpdate.getItemCategoryId(), updatedItem.getItemCategoryId());
		Assert.assertEquals(itemToUpdate.getItemId(), updatedItem.getItemId());
		Assert.assertEquals(itemToUpdate.getItemName().compareTo(updatedItem.getItemName()), 0);
	}
	
	@Test
	public void deleteItem() {
		Item itemToDelete = new Item();
		itemToDelete.setItemCategoryId(1L);
		itemToDelete.setItemId(1L);
		itemToDelete.setItemName("Test Item");
		
		Optional<Item> deletedItemOptional = Optional.of(itemToDelete);
		
		Mockito.when(itemRepository.findById(1L)).thenReturn(deletedItemOptional);
		
		Item deletedItem = itemService.deleteItem(1L);
		
		Assert.assertEquals(itemToDelete.getItemCategoryId(), deletedItem.getItemCategoryId());
		Assert.assertEquals(itemToDelete.getItemId(), deletedItem.getItemId());
		Assert.assertEquals(itemToDelete.getItemName().compareTo(deletedItem.getItemName()), 0);
	}
	
	//Negative Tests
	
	@Test
	public void retrieveItemDoesNotExist() {
		Item itemToRetrieve = new Item();
		itemToRetrieve.setItemCategoryId(1L);
		itemToRetrieve.setItemId(1L);
		itemToRetrieve.setItemName("Test Item");
		
		List<Item> retrievedItemsList = new ArrayList<Item>();
		
		Mockito.when(itemRepository.findItemsByItemCategoryId(2L)).thenReturn(retrievedItemsList);
		
		List<Item> retrievedItems = itemService.getItemsByCategoryId(2L);
		
		Assert.assertEquals(retrievedItems.size(), 0);
	}
	
	@Test
	public void updateItemDoesNotExist() {
		Item itemToUpdate = new Item();
		itemToUpdate.setItemCategoryId(1L);
		itemToUpdate.setItemId(1L);
		itemToUpdate.setItemName("Test Item Edited");
		
		UpdateItemDto updateItemDto = new UpdateItemDto();
		updateItemDto.setItemId(2L);
		updateItemDto.setNewItemName("Test Item Edited");
		
		Optional<Item> updatedItemOptional = Optional.empty();
		
		Mockito.when(itemRepository.findById(2L)).thenReturn(updatedItemOptional);
		
		Item updatedItem = itemService.updateItem(updateItemDto);
		
		Assert.assertEquals(updatedItem, null);
	}
	
	@Test
	public void deleteItemDoesNotExist() {
		Item itemToDelete = new Item();
		itemToDelete.setItemCategoryId(1L);
		itemToDelete.setItemId(1L);
		itemToDelete.setItemName("Test Item");
		
		Optional<Item> deletedItemOptional = Optional.empty();
		
		Mockito.when(itemRepository.findById(2L)).thenReturn(deletedItemOptional);
		
		Item deletedItem = itemService.deleteItem(2L);
		
		Assert.assertEquals(deletedItem, null);
	}
}
