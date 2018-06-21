package com.training.wcd.dao.common;

import java.util.List;

public interface BaseDao<T> {
	
	T find(Integer id);
	
	List<T> findAll();
	
	T save(T object);
	
	void delete(Integer id);
}
