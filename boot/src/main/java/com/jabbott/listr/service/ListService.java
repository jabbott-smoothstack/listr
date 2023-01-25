package com.jabbott.listr.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dto.NewListDto;
import com.jabbott.listr.dto.UpdateListDto;
import com.jabbott.listr.model.List;
import com.jabbott.listr.repository.ListRepository;

@Service
@Transactional
public class ListService {

	@Autowired
	private ListRepository listRepository;
	
	public java.util.List<List> getListsByUserId(Long userId) {
		return listRepository.findListsByListUserId(userId);
	}

	public List createNewList(NewListDto newListDto) {
		List newList = new List();
		newList.setListName(newListDto.getListName());
		newList.setListUserId(newListDto.getUserId());
		listRepository.save(newList);
		return newList;
	}

	public List updateList(UpdateListDto updateListDto) {
		Optional<List> toUpdate = listRepository.findById(updateListDto.getListId());
		if(toUpdate.isPresent()) {
			List list = toUpdate.get();
			list.setListName(updateListDto.getNewListName());
			listRepository.save(list);
			return list;
		}
		else return null;
	}

	public List deleteList(Long listId) {
		Optional<List> toDelete = listRepository.findById(listId);
		if(toDelete.isPresent()) {
			List list = toDelete.get();
			listRepository.deleteById(listId);
			return list;
		}
		else return null;
	}
	
}