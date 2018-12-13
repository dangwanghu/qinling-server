package com.tfssoft.qinling.jiucuo.repository.impl;

import java.util.List;

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

	@Override
	public List<Correction> getJiuCuoPageList(String content, int skip, int limit, String status, String statusIn, String userId) {
		return this.findAll(JiuCuoSql.getPageListSql(content, skip, limit, status, statusIn, userId));
	}

	@Override
	public List<Correction> getJiuCuoList(String content, String status, String statusIn, String userId) {
		return this.findAll(JiuCuoSql.getListSql(content, status, statusIn, userId));
	}

	@Override
	public long getJiuCuoCount(String content, String status, String statusIn, String userId) {
		return this.findCount(JiuCuoSql.getCountSql(content, status, statusIn, userId));
	}

	@Override
	public void updateJiuCuo(Correction instance) {
		this.update(JiuCuoSql.getUpdateJiuCuoSql(instance));
	}

	@Override
	public void deleteJiuCuo(int id) {
		this.removeOne(JiuCuoSql.DELETE_JIUCUO, id);
	}

	@Override
	public void updateJiuCuoBatch(String ids, String status) {
		this.update(JiuCuoSql.getBatchUpdateJiuCuoSql(ids, status));
	}

}
