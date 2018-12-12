package com.tfssoft.qinling.base.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.domain.TopicAuth;

public interface TopicService {
	
	public List<Topic> getTopicList(String name, String userId);

	public void addTopicAuth(TopicAuth instance);

	public Topic getTopicDetail(String userId, String id, String type);

	public List<TopicAuth> getTopicAuthList(Integer skip, Integer limit, String name, String source);

	public long getTopicAuthCount(String name, String source);

	public void updateTopicAuth(Integer id, String status, String comments);

	public void deleteTopicAuthAdmin(String ids);

	public void deleteTopicAuth(String ids);

}
