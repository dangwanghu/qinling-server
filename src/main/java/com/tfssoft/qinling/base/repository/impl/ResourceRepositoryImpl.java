package com.tfssoft.qinling.base.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Resource;
import com.tfssoft.qinling.base.domain.ResourceSql;
import com.tfssoft.qinling.base.repository.ResourceRepository;

@Repository	
public class ResourceRepositoryImpl extends AbstractRepository<Resource> implements ResourceRepository {

	@Override
	public List<Resource> getResourceByLevel(Integer level) {
		return this.findAll(ResourceSql.getListSql(level));
	}
	
}
