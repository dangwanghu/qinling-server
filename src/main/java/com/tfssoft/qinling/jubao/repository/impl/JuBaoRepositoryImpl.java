package com.tfssoft.qinling.jubao.repository.impl;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.jubao.domain.JuBaoSql;
import com.tfssoft.qinling.jubao.domain.Report;
import com.tfssoft.qinling.jubao.repository.JubaoRepository;

@Repository
public class JuBaoRepositoryImpl extends AbstractRepository<Report> implements JubaoRepository {

	@Override
	public void addJuBao(Report instance) {
		this.insert(JuBaoSql.INSRT_JUBAO, JuBaoSql.getInsertObject(instance));
	}

}
