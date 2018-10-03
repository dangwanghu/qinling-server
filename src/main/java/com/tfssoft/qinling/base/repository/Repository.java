package com.tfssoft.qinling.base.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T extends Serializable> {

	public int insert(String sql, Object...args);
	
	public void insertBatch(String sql, List<Object[]> batchArgs);
	
	public int update(String sql);

	public T findOne(String sql);

	public List<T> findAll(String sql);

	public int removeOne(String sql, int id);
}
