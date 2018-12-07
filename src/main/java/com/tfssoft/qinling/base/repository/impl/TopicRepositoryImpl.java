package com.tfssoft.qinling.base.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.domain.TopicAuth;
import com.tfssoft.qinling.base.domain.TopicSql;
import com.tfssoft.qinling.base.repository.TopicRepository;

@Repository	
public class TopicRepositoryImpl extends AbstractRepository<Topic> implements TopicRepository {

	@Override
	public List<Topic> getTopicList(String name) {
		return this.findAll(TopicSql.getTopicListSql(name));
	}

	@Override
	public void addTopicAuth(TopicAuth instance) {
		this.insert(TopicSql.INSRT_TOPIC_AUTH, TopicSql.getInsertAuthObject(instance));
	}

}
