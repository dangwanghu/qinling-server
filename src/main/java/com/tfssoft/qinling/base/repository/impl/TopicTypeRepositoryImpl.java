package com.tfssoft.qinling.base.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.domain.TopicSql;
import com.tfssoft.qinling.base.domain.TopicType;
import com.tfssoft.qinling.base.repository.TopicTypeRepository;

@Repository
public class TopicTypeRepositoryImpl extends AbstractRepository<TopicType> implements TopicTypeRepository {

	@Override
	public List<TopicType> getTopicTypeList() {
		return this.findAll(TopicSql.GET_TOPIC_TYPE_LIST);
	}

}
