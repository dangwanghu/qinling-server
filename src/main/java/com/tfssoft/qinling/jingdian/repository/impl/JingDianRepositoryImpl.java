package com.tfssoft.qinling.jingdian.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.jingdian.domain.JingDianSql;
import com.tfssoft.qinling.jingdian.repository.JingDianRepository;

@Repository
public class JingDianRepositoryImpl extends AbstractRepository<Topic> implements JingDianRepository {

	@Override
	public List<Topic> getJingDianList(String name, String userId) {
		return this.findAll(JingDianSql.getListSql(name, userId));
	}
	
	@Override
	public List<Topic> getJingDianPageList(String name, int skip, int limit, String userId) {
		return this.findAll(JingDianSql.getPageListSql(name, skip, limit, userId));
	}

	@Override
	public void addJingDian(Topic instance) {
		this.insert(JingDianSql.INSERT_JINGDIAN, JingDianSql.getInsertObject(instance));
	}

	@Override
	public long getJingDianCount(String name) {
		return this.findCount(JingDianSql.getCountSql(name));
	}

	@Override
	public void updateJingDian(Topic instance) {
		this.update(JingDianSql.getUpdateSql(instance));
	}

	@Override
	public void deleteJingDian(int id) {
		this.removeOne(JingDianSql.DELETE_JINGDIAN, id);
	}
	

}
