package com.training.wcd.service.common;

import java.util.List;

import com.training.wcd.dao.common.BaseDao;

public class BaseServiceImpl<T> implements BaseService<T> {

	protected BaseDao<T> dao;

	public T find(Integer id) {
		return this.dao.find(id);
	}

	public List<T> findAll() {
		return this.dao.findAll();
	}

	public void delete(Integer id) {
		this.dao.delete(id);
	}

	public T save(T object) {
		return this.dao.save(object);
	}

	public List<T> search(String namedQuery) {
		return null;
	}
}

