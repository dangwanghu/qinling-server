package com.tfssoft.qinling.jianyi.repository.impl;

import java.util.List;

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

	@Override
	public List<Suggest> getJianYiPageList(String content, int skip, int limit, String status) {
		return this.findAll(JianYiSql.getPageListSql(content, skip, limit, status));
	}

	@Override
	public List<Suggest> getJianYiList(String content, String status) {
		return this.findAll(JianYiSql.getListSql(content, status));
	}

	@Override
	public long getJianYiCount(String content, String status) {
		return this.findCount(JianYiSql.getCountSql(content, status));
	}

	@Override
	public void updateJianYi(Suggest instance) {
		this.update(JianYiSql.getUpdateJianYiSql(instance));
	}

	@Override
	public void deleteJianYi(int id) {
		this.removeOne(JianYiSql.DELETE_JIANYI, id);
	}

	@Override
	public void updateJianYiBatch(String ids, String status) {
		this.update(JianYiSql.getBatchUpdateJianYiSql(ids, status));
	}

}
