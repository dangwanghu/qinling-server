package com.tfssoft.qinling.yukou.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.yukou.domain.YuKouSql;
import com.tfssoft.qinling.yukou.repository.YuKouRepository;

@Repository
public class YuKouRepositoryImpl extends AbstractRepository<Topic> implements YuKouRepository {

	@Override
	public List<Topic> getYuKouList(Integer xiangzhen) {
		return this.findAll(YuKouSql.getYuListSql(xiangzhen));
	}
}
