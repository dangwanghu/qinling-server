package com.tfssoft.qinling.base.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface TopicRepository {

	public List<Topic> getTopicList(String name, String userId);

	public Topic getTopicDetail(String userId, String id, String type);
}
