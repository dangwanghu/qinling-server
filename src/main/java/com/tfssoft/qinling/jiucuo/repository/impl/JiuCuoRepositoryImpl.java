package com.tfssoft.qinling.jiucuo.repository.impl;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.jiucuo.domain.Correction;
import com.tfssoft.qinling.jiucuo.domain.JiuCuoSql;
import com.tfssoft.qinling.jiucuo.repository.JiuCuoRepository;

@Repository
public class JiuCuoRepositoryImpl extends AbstractRepository<Correction> implements JiuCuoRepository {

	@Override
	public void addJiuCuo(Correction instance) {
		this.insert(JiuCuoSql.INSRT_JIUCUO, JiuCuoSql.getInsertObject(instance));
	}

}
