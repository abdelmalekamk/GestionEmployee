package com.training.wcd.service.common;

import java.util.List;

public interface BaseService<T> {

	T find(Integer id);

	List<T> findAll();

	void delete(Integer id);

	T save(T object);

}
