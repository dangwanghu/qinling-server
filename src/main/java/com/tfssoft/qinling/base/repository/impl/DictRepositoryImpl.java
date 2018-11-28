package com.tfssoft.qinling.base.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Dict;
import com.tfssoft.qinling.base.domain.DictSql;
import com.tfssoft.qinling.base.repository.DictRepository;

@Repository	
public class DictRepositoryImpl extends AbstractRepository<Dict> implements DictRepository {

	@Override
	public List<Dict> getQxList() {
		return this.findAll(DictSql.GET_DICT_QX_LIST);
	}

	@Override
	public List<Dict> getXzList(Integer quxian) {
		return this.findAll(DictSql.getXzListSql(quxian));
	}

}
