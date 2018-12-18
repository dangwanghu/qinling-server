package com.tfssoft.qinling.shanfeng.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.shanfeng.domain.ShanFengSql;
import com.tfssoft.qinling.shanfeng.repository.ShanFengRepository;

@Repository
public class ShanFengRepositoryImpl extends AbstractRepository<Topic> implements ShanFengRepository {

	@Override
	public List<Topic> getShanFengList(String name, String userId) {
		return this.findAll(ShanFengSql.getListSql(name, userId));
	}

	@Override
	public void addShanFeng(Topic instance) {
		this.insert(ShanFengSql.INSERT_SHANFENG, ShanFengSql.getInsertObject(instance));
	}

	@Override
	public List<Topic> getShanFengPageList(String name, int skip, int limit, String userId) {
		return this.findAll(ShanFengSql.getPageListSql(name, skip, limit, userId));
	}

	@Override
	public long getShanFengCount(String name) {
		return this.findCount(ShanFengSql.getCountSql(name));
	}

	@Override
	public void updateShanFeng(Topic instance) {
		this.update(ShanFengSql.getUpdateSql(instance));
	}

	@Override
	public void deleteShanFeng(int id) {
		this.removeOne(ShanFengSql.DELETE_SHANFENG, id);
	}

}
