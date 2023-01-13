package com.jabbott.listr.dao;

import java.util.List;

public interface Dao<T extends Object> {
		
	public T save(T model);
	
	public T findById(Long id);
	
	public T deleteById(Long id);
	
	public List<T> findAll();
}
