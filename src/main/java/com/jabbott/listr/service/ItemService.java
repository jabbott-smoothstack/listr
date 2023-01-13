package com.jabbott.listr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.ItemDao;
import com.jabbott.listr.model.Item;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public Item findItemById(Long itemId) {
		return itemDao.findById(itemId);
	}
	
	// TODO Refactor this method
	public Item createItem(Item newItem) {
		if(itemDao.findById(newItem.getItemId()) == null) {
			return itemDao.save(newItem);
		}
		else return null;
	}
	
	public List<Item> findItemsByCategoryId(Long categoryId) {
		return itemDao.findAllByCategoryId(categoryId);
	}
	
	public Item deleteItemById(Long itemId) {
		return itemDao.deleteById(itemId);
	}
}
