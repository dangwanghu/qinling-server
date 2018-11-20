package com.tfssoft.qinling.base.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tfssoft.qinling.base.repository.Repository;

public abstract class AbstractRepository<T extends Serializable> implements Repository<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private Class<T> entity;

	@SuppressWarnings("unchecked")
	protected AbstractRepository() {
		entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll(String sql) {
		return (List<T>) jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<T>(entity));
	}

	@Override
	public int update(String sql) {
		return jdbcTemplate.update(sql);
	}

	@Override
	public T findOne(String sql) {
		List<T> list = (List<T>) jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<T>(entity));
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int insert(String sql, Object... args) {
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public void insertBatch(String sql, List<Object[]> batchArgs) {
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	@Override
	public int removeOne(String sql, int id) {
		return jdbcTemplate.update(sql, id);
	}

}
