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
	public List<Topic> getJingDianList(String userId) {
		return this.findAll(JingDianSql.getJingDianListSql(userId));
	}

	@Override
	public void addJingDian(Topic instance) {
		this.insert(JingDianSql.INSERT_JINGDIAN, JingDianSql.getInsertObject(instance));
	}

}
