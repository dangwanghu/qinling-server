package com.tfssoft.qinling.base.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.domain.TopicAuth;

public interface TopicRepository {

	public List<Topic> getTopicList(String name, String userId);

	public void addTopicAuth(TopicAuth instance);
}
