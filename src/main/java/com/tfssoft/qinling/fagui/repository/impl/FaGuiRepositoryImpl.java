package com.tfssoft.qinling.fagui.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.fagui.domain.FaGuiSql;
import com.tfssoft.qinling.fagui.domain.Rule;
import com.tfssoft.qinling.fagui.repository.FaGuiRepository;

@Repository
public class FaGuiRepositoryImpl extends AbstractRepository<Rule> implements FaGuiRepository {

	@Override
	public List<Rule> getFaGuiList(String name) {
		return this.findAll(FaGuiSql.getListSql(name));
	}

	@Override
	public List<Rule> getFaGuiPageList(String name, int skip, int limit) {
		return this.findAll(FaGuiSql.getPageListSql(name, skip, limit));
	}

	@Override
	public long getCunZhuangCount(String name) {
		return this.findCount(FaGuiSql.getCountSql(name));
	}

	@Override
	public void addFaGui(Rule instance) {
		this.insert(FaGuiSql.INSERT_FAGUI, FaGuiSql.getInsertObject(instance));
	}

	@Override
	public void deleteFaGui(int id) {
		this.removeOne(FaGuiSql.DELETE_FAGUI, id);
	}

	@Override
	public void updateFaGui(Rule instance) {
		this.update(FaGuiSql.getUpdateFaGuiSql(instance));
	}

}
