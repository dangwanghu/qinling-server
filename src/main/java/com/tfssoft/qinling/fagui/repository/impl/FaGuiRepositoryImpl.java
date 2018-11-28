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

}
