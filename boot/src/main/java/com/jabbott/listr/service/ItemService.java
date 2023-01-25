package com.jabbott.listr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dto.NewItemDto;
import com.jabbott.listr.dto.UpdateItemDto;
import com.jabbott.listr.model.Item;
import com.jabbott.listr.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getItemsByCategoryId(Long categoryId) {
		return itemRepository.findItemsByItemCategoryId(categoryId);
	}

	public Item createNewItem(NewItemDto newItemDto) {
		Item newItem = new Item();
		newItem.setItemName(newItemDto.getItemName());
		newItem.setItemCategoryId(newItemDto.getItemCategoryId());
		itemRepository.save(newItem);
		return newItem;
	}

	public Item updateItem(UpdateItemDto updateItemDto) {
		Optional<Item> toUpdate = itemRepository.findById(updateItemDto.getItemId());
		
		if(toUpdate.isPresent()) {
			Item item = toUpdate.get();
			item.setItemName(updateItemDto.getItemName());
			itemRepository.save(item);
			return item;
		}
		else return null;
	}

	public Item deleteItem(Long itemId) {
		Optional<Item> toDelete = itemRepository.findById(itemId);
		if(toDelete.isPresent()) {
			Item item = toDelete.get();
			itemRepository.deleteById(itemId);
			return item;
		}
		else return null;
	}
	
}