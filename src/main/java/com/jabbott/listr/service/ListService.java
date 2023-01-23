package com.jabbott.listr.service;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.ListDao;
import com.jabbott.listr.dto.ListDto;
import com.jabbott.listr.dto.UpdateListDto;
import com.jabbott.listr.model.List;

@Service("listService")
@Transactional
public class ListService {
	
	@Autowired
	private ListDao listDao;
	
	public List createList(HashMap<String, String> newListInfo) {
		List newList = new List();
		newList.setListName(newListInfo.get("listName"));
		newList.setListUserId(Long.parseLong(newListInfo.get("userId")));
		listDao.save(newList);
		return newList;
	}
	
	public List findById(Long id) {
		return listDao.findById(id);
	}
	
	public java.util.List<List> findAllByUserId(Long id) {
		return listDao.findAllByUserId(id);
	}
	
	public List deleteList(Long id) {
		List toDelete = findById(id);
		listDao.delete(toDelete);
		return toDelete;
	}
	
	public List updateList(UpdateListDto updateListDto) {
		listDao.editList(updateListDto);
		return listDao.findById(updateListDto.getListId());
	}
}
