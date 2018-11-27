package com.tfssoft.qinling.cunzhuang.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.cunzhuang.domain.CunZhuangSql;
import com.tfssoft.qinling.cunzhuang.repository.CunZhuangRepository;

@Repository	
public class CunZhuangRepositoryImpl extends AbstractRepository<Topic> implements CunZhuangRepository {

	@Override
	public List<Topic> getCunZhuangList(String name) {
		return this.findAll(CunZhuangSql.getListSql(name));
	}

	@Override
	public void addCunZhuang(Topic instance) {
		this.insert(CunZhuangSql.INSERT_CUNZHUANG, CunZhuangSql.getInsertObject(instance));
	}

	@Override
	public List<Topic> getCunZhuangPageList(String name, int skip, int limit) {
		return this.findAll(CunZhuangSql.getPageListSql(name, skip, limit));
	}

	@Override
	public long getCunZhuangCount(String name) {
		return this.findCount(CunZhuangSql.getCountSql(name));
	}

	@Override
	public void updateCunZhuang(Topic instance) {
		this.update(CunZhuangSql.getUpdateCunZhuangSql(instance));
	}

	@Override
	public void deleteCunZhuang(int id) {
		this.removeOne(CunZhuangSql.DELETE_CUNZHUANG, id);
	}

}
