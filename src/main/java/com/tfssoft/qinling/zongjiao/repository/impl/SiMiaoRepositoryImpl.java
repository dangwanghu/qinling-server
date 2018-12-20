package com.tfssoft.qinling.zongjiao.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.jingdian.domain.JingDianSql;
import com.tfssoft.qinling.zongjiao.domain.SiMiaoSql;
import com.tfssoft.qinling.zongjiao.repository.SiMiaoRepository;

@Repository
public class SiMiaoRepositoryImpl extends AbstractRepository<Topic> implements SiMiaoRepository {

	@Override
	public List<Topic> getSiMiaoList(String name, String userId) {
		return this.findAll(SiMiaoSql.getSiMiaoListSql(name, userId));
	}

	@Override
	public void addSiMiao(Topic instance) {
		this.insert(SiMiaoSql.INSERT_SIMIAO, JingDianSql.getInsertObject(instance));
	}

	@Override
	public List<Topic> getSiMiaoPageList(String name, String userId, int skip, int limit) {
		return this.findAll(SiMiaoSql.getSiMiaoPageList(name, userId, skip, limit));
	}

	@Override
	public long getSiMiaoCount(String name) {
		return this.findCount(SiMiaoSql.getCountSql(name));
	}

	@Override
	public void updateSiMiao(Topic instance) {
		this.update(SiMiaoSql.getUpdateSql(instance));
	}

	@Override
	public void deleteSiMiao(int id) {
		this.removeOne(SiMiaoSql.DELETE_SIMIAO, id);
	}

}
