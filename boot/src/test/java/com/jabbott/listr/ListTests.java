package com.jabbott.listr;

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

import com.jabbott.listr.dto.NewListDto;
import com.jabbott.listr.dto.UpdateListDto;
import com.jabbott.listr.model.List;
import com.jabbott.listr.repository.ListRepository;
import com.jabbott.listr.service.ListService;

@ActiveProfiles("test")
@SpringBootTest(classes = {ListService.class, UnitTestConfiguration.class})
public class ListTests extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private ListService listService;
	
	@Autowired
	private ListRepository listRepository;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	//Positive Tests
	
	@Test
	public void createList() {
		NewListDto newListDto = new NewListDto();
		newListDto.setListName("Test List");
		newListDto.setUserId(1L);
		
		List newList = new List();
		newList.setListName("Test List");
		newList.setListUserId(1L);
		
		Mockito.when(listRepository.save(newList)).thenReturn(newList);
		
		List createdList = listService.createNewList(newListDto);
		
		Assert.assertEquals(createdList.getListId(), newList.getListId());
		Assert.assertEquals(newList.getListName().compareTo(createdList.getListName()), 0);
		Assert.assertEquals(newList.getListUserId(), createdList.getListUserId());
		
	}
	
	@Test
	public void retrieveList() {
		List newList = new List();
		newList.setListId(1L);
		newList.setListName("Test List");
		newList.setListUserId(1L);
		
		java.util.List<List> listToRetrieve = new java.util.ArrayList<List>();
		listToRetrieve.add(newList);
		
		Mockito.when(listRepository.findListsByListUserId(newList.getListUserId())).thenReturn(listToRetrieve);
		
		java.util.List<List> retrievedList = listService.getListsByUserId(newList.getListId());
		List retrievedItemList = retrievedList.get(0);
		
		Assert.assertEquals(retrievedItemList.getListId(), newList.getListId());
		Assert.assertEquals(retrievedItemList.getListName().compareTo(newList.getListName()), 0);
		Assert.assertEquals(retrievedItemList.getListUserId(), newList.getListUserId());
	}
	
	@Test
	public void updateList() {
		List listToUpdate = new List();
		listToUpdate.setListId(1L);
		listToUpdate.setListName("Test List");
		listToUpdate.setListUserId(1L);
		
		UpdateListDto updateListDto = new UpdateListDto();
		updateListDto.setListId(1L);
		updateListDto.setNewListName("Test List Edited");
		
		List updatedList = new List();
		updatedList.setListId(listToUpdate.getListId());
		updatedList.setListName(updateListDto.getNewListName());
		updatedList.setListUserId(listToUpdate.getListUserId());
		
		Mockito.when(listRepository.save(updatedList)).thenReturn(updatedList);
		
		List retrievedUpdatedList = listService.updateList(updateListDto);
		
		Assert.assertEquals(retrievedUpdatedList.getListName().compareTo(updatedList.getListName()),0);
		Assert.assertEquals(retrievedUpdatedList.getListId(), updatedList.getListId());
		Assert.assertEquals(retrievedUpdatedList.getListUserId(), updatedList.getListUserId());
	}
	
	@Test
	public void deleteList() {
		List listToDelete = new List();
		listToDelete.setListId(1L);
		listToDelete.setListName("Test List");
		listToDelete.setListUserId(1L);
		
		Optional<List> deletedListOptional = Optional.of(listToDelete);
		
		Mockito.when(listRepository.findById(listToDelete.getListId())).thenReturn(deletedListOptional);
		
		List deletedList = listService.deleteList(1L);
		
		Assert.assertEquals(listToDelete.getListId(), deletedList.getListId());
		Assert.assertEquals(listToDelete.getListName().compareTo(deletedList.getListName()), 0);
		Assert.assertEquals(listToDelete.getListUserId(), deletedList.getListUserId());
	}
	
	//Negative Tests
	
	@Test
	public void retrieveListDoesNotExist() {
		List listToRetrieve = new List();
		listToRetrieve.setListId(1L);
		listToRetrieve.setListName("Test List");
		listToRetrieve.setListUserId(1L);
		
		java.util.List<List> retreivedItemLists = new java.util.ArrayList<List>();
		
		Mockito.when(listRepository.findListsByListUserId(2L)).thenReturn(retreivedItemLists);
		
		java.util.List<List> retrievedLists = listService.getListsByUserId(2L);
		
		Assert.assertEquals(retrievedLists.size(), 0);
	}
	
	@Test
	public void updateListDoesNotExist() {
		List listToUpdate = new List();
		listToUpdate.setListId(1L);
		listToUpdate.setListName("Test List");
		listToUpdate.setListUserId(1L);
		
		UpdateListDto updateListDto = new UpdateListDto();
		updateListDto.setListId(2L);
		updateListDto.setNewListName("Test List Edited");
		
		Optional<List> updatedListOptional = Optional.empty();
		
		Mockito.when(listRepository.findById(2L)).thenReturn(updatedListOptional);
		
		List updatedList = listService.updateList(updateListDto);
		
		Assert.assertEquals(updatedList, null);
	}
	
	@Test
	public void deleteListDoesNotExist() {
		List listToDelete = new List();
		listToDelete.setListId(1L);
		listToDelete.setListName("Test List");
		listToDelete.setListUserId(1L);
		
		Optional<List> deletedListOptional = Optional.empty();
		
		Mockito.when(listRepository.findById(2L)).thenReturn(deletedListOptional);
		
		List deletedList = listService.deleteList(2L);
		
		Assert.assertEquals(deletedList, null);
	}
}
