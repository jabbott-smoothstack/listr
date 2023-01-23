package com.jabbott.listr.dao;

import java.util.List;

public interface Dao<T extends Object> {
	
	public T save(T object);
	public T delete(T object);
	public T findById(Long id);
	public List<T> findAll();
}
