package com.tfssoft.qinling.base.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.TopicAuth;
import com.tfssoft.qinling.base.domain.TopicAuthSql;
import com.tfssoft.qinling.base.repository.TopicAuthRepository;

@Repository
public class TopicAuthRepositoryImpl extends AbstractRepository<TopicAuth> implements TopicAuthRepository {

	@Override
	public void addTopicAuth(TopicAuth instance) {
		this.insert(TopicAuthSql.INSRT_TOPIC_AUTH, TopicAuthSql.getInsertObject(instance));
	}

	@Override
	public List<TopicAuth> getTopicAuthList(String name, String status) {
		return this.findAll(TopicAuthSql.getListSql(name, status));
	}

	@Override
	public List<TopicAuth> getTopicAuthPageList(String name, int skip, int limit, String status) {
		return this.findAll(TopicAuthSql.getPageListSql(name, skip, limit, status));
	}

	@Override
	public long getTopicAuthCount(String name, String status) {
		return this.findCount(TopicAuthSql.getCountSql(name, status));
	}

	@Override
	public void deleteTopicAuthAdmin(String ids) {
		this.update(TopicAuthSql.getDeleteTopicAuthSql(ids));
	}

	@Override
	public void updateTopicAuth(TopicAuth instance) {
		this.update(TopicAuthSql.getUpdateTopicAuthSql(instance));
	}

	@Override
	public void batchUpdateTopicAuth(String ids, String status) {
		this.update(TopicAuthSql.getBatchUpdateTopicAuthSql(ids, status));
	}

}
