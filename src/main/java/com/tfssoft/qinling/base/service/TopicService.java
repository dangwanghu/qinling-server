package com.tfssoft.qinling.base.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.AuthVO;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.domain.TopicAuth;
import com.tfssoft.qinling.base.domain.TopicType;

public interface TopicService {
	
	public List<Topic> getTopicList(String name, String userId);

	public void addTopicAuth(TopicAuth instance);

	public Topic getTopicDetail(String userId, String id, String type);

	public List<TopicAuth> getTopicAuthList(Integer skip, Integer limit, String name, String source, String userId, String status, Integer type);

	public long getTopicAuthCount(String name, String source, String userId, String status, Integer type);

	public void updateTopicAuth(AuthVO authInstance);

	public void deleteTopicAuthAdmin(String ids);

	public void deleteTopicAuth(String ids);

	public List<TopicType> getTopicTypeList();

}
