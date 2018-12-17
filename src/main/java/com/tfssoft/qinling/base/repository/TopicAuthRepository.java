package com.tfssoft.qinling.base.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.TopicAuth;

public interface TopicAuthRepository {
	
	public void addTopicAuth(TopicAuth instance);

	public List<TopicAuth> getTopicAuthList(String name, String statusIn, String userId, String status);

	public List<TopicAuth> getTopicAuthPageList(String name, int skip, int limit, String statusIn, String userId, String status);

	public long getTopicAuthCount(String name, String statusIn, String userId, String status);

	public void deleteTopicAuthAdmin(String ids);

	public void updateTopicAuth(TopicAuth instance);

	public void batchUpdateTopicAuth(String ids, String status);

	public TopicAuth getTopicAuthById(int id);
}
