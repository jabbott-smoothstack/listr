package com.jabbott.listr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jabbott.listr.dao.ListDao;
import com.jabbott.listr.model.List;

@Service
public class ListService {
	
	@Autowired
	private ListDao listDao;
	
	public List getListById(Long listId) {
		return listDao.findById(listId);
	}
	
	public java.util.List<List> getListsByUserId(Long userId) {
		return listDao.findAllByUserId(userId);
	}
	
	public List deleteListById(Long listId) {
		return listDao.deleteById(listId);
	}
	
	// TODO Refactor this method
	public List createList(List newList) {
		if(listDao.findById(newList.getListId()) == null) {
			return listDao.save(newList);
		}
		else return null;
	}
}
