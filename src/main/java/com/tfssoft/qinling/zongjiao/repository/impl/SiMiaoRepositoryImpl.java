package com.tfssoft.qinling.zongjiao.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.zongjiao.domain.SiMiaoSql;
import com.tfssoft.qinling.zongjiao.repository.SiMiaoRepository;

@Repository
public class SiMiaoRepositoryImpl extends AbstractRepository<Topic> implements SiMiaoRepository {

	@Override
	public List<Topic> getSiMiaoList(String userId) {
		return this.findAll(SiMiaoSql.getSiMiaoListSql(userId));
	}

}
