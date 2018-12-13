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
	public List<Report> getJuBaoPageList(String content, int skip, int limit, String status, String statusIn, String userId) {
		return this.findAll(JuBaoSql.getPageListSql(content, skip, limit, status, statusIn, userId));
	}

	@Override
	public List<Report> getJuBaoList(String content, String status, String statusIn, String userId) {
		return this.findAll(JuBaoSql.getListSql(content, status, statusIn, userId));
	}

	@Override
	public long getJuBaoCount(String content, String status, String statusIn, String userId) {
		return this.findCount(JuBaoSql.getCountSql(content, status, statusIn, userId));
	}

	@Override
	public void updateJuBao(Report instance) {
		this.update(JuBaoSql.getUpdateJuBaoSql(instance));
	}

	@Override
	public void deleteJuBao(int id) {
		this.removeOne(JuBaoSql.DELETE_JUBAO, id);
	}

	@Override
	public void updateJuBaoBatch(String ids, String status) {
		this.update(JuBaoSql.getBatchUpdateJuBaoSql(ids, status));
	}
}
