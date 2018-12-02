package com.tfssoft.qinling.jubao.repository.impl;

import java.util.List;

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

	@Override
	public List<Report> getJuBaoPageList(String content, int skip, int limit) {
		return this.findAll(JuBaoSql.getPageListSql(content, skip, limit));
	}

	@Override
	public List<Report> getJuBaoList(String content) {
		return this.findAll(JuBaoSql.getListSql(content));
	}

	@Override
	public long getJuBaoCount(String content) {
		return this.findCount(JuBaoSql.getCountSql(content));
	}

	@Override
	public void updateJuBao(Report instance) {
		this.update(JuBaoSql.getUpdateJuBaoSql(instance));
	}

	@Override
	public void deleteJuBao(int id) {
		this.removeOne(JuBaoSql.DELETE_JUBAO, id);
	}
}
