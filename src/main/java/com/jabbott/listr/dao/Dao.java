package com.jabbott.listr.dao;

public interface Dao<T extends Object> {
	
	public Dao<T> convertFromModel(T model);
	
}
