package com.tfssoft.qinling.jianyi.repository.impl;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.jianyi.domain.JianYiSql;
import com.tfssoft.qinling.jianyi.domain.Suggest;
import com.tfssoft.qinling.jianyi.repository.JianYiRepository;

@Repository
public class JianYiRepositoryImpl extends AbstractRepository<Suggest> implements JianYiRepository {

	@Override
	public void addJianYi(Suggest instance) {
		this.insert(JianYiSql.INSRT_JIANYI, JianYiSql.getInsertObject(instance));
	}

}
