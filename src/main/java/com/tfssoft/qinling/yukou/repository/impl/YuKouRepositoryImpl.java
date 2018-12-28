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
	public List<Topic> getYuKouList(Integer xiangzhen, String name, String userId) {
		return this.findAll(YuKouSql.getYuKouListSql(xiangzhen, name, userId));
	}

	@Override
	public void addYuKou(Topic instance) {
		this.insert(YuKouSql.INSERT_YUKOU, YuKouSql.getInsertObject(instance));
	}

	@Override
	public List<Topic> getYuKouPageList(Integer xiangzhen, String name, String userId, int skip, int limit) {
		return this.findAll(YuKouSql.getYuKouPageList(xiangzhen, name, userId, skip, limit));
	}

	@Override
	public long getYuKouCount(Integer xiangzhen, String name) {
		return this.findCount(YuKouSql.getCountSql(xiangzhen, name));
	}

	@Override
	public void updateYuKou(Topic instance) {
		this.update(YuKouSql.getUpdateSql(instance));
	}

	@Override
	public void deleteYuKou(int id) {
		this.removeOne(YuKouSql.DELETE_YUKOU, id);
	}
}
