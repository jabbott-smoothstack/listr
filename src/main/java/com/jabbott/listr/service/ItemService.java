package com.jabbott.listr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.ItemDao;
import com.jabbott.listr.dto.ItemDto;
import com.jabbott.listr.dto.UpdateItemDto;
import com.jabbott.listr.model.Item;

@Service("itemService")
@Transactional
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	public Item createItem(ItemDto newItemDto) {
		Item newItem = new Item();
		newItem.setItemName(newItemDto.getItemName());
		newItem.setItemCategoryId(newItemDto.getCategoryId());
		return itemDao.save(newItem);
	}
	
	public Item findById(Long id) {
		return itemDao.findById(id);
	}
	
	public List<Item> findItemsByCategoryId(Long id) {
		return itemDao.findAllByCategoryId(id);
	}
	
	public Item deleteItem(Long id) {
		Item toDelete = findById(id);
		itemDao.delete(toDelete);
		return toDelete;
	}
	
	public Item updateItem(UpdateItemDto updateItemDto) {
		itemDao.editItem(updateItemDto);
		return itemDao.findById(updateItemDto.getItemId());
	}
}
