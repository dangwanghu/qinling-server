package com.tfssoft.qinling.cunzhuang.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.cunzhuang.domain.CunZhuangSql;
import com.tfssoft.qinling.cunzhuang.repository.CunZhuangRepository;

@Repository
public class CunZhuangRepositoryImpl extends AbstractRepository<Topic> implements CunZhuangRepository {

	@Override
	public List<Topic> getCunZhuangList() {
		return this.findAll(CunZhuangSql.GET_CUNZHUANG_LIST);
	}

}
