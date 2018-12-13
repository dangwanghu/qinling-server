package com.tfssoft.qinling.base.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.TopicAuth;

public interface TopicAuthRepository {
	
	public void addTopicAuth(TopicAuth instance);

	public List<TopicAuth> getTopicAuthList(String name, String status, String userId);

	public List<TopicAuth> getTopicAuthPageList(String name, int skip, int limit, String status, String userId);

	public long getTopicAuthCount(String name, String status, String userId);

	public void deleteTopicAuthAdmin(String ids);

	public void updateTopicAuth(TopicAuth instance);

	public void batchUpdateTopicAuth(String ids, String status);

	public TopicAuth getTopicAuthById(int id);
}
