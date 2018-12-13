package com.tfssoft.qinling.shanfeng.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.jingdian.domain.JingDianSql;
import com.tfssoft.qinling.shanfeng.domain.ShanFengSql;
import com.tfssoft.qinling.shanfeng.repository.ShanFengRepository;

@Repository
public class ShanFengRepositoryImpl extends AbstractRepository<Topic> implements ShanFengRepository {

	@Override
	public List<Topic> getShanFengList(String userId) {
		return this.findAll(ShanFengSql.getShanFengListSql(userId));
	}

	@Override
	public void addShanFeng(Topic instance) {
		this.insert(ShanFengSql.INSERT_SHANFENG, JingDianSql.getInsertObject(instance));
	}

}
