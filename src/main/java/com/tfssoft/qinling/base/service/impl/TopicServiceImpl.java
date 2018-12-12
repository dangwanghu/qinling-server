package com.tfssoft.qinling.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.domain.TopicAuth;
import com.tfssoft.qinling.base.repository.TopicAuthRepository;
import com.tfssoft.qinling.base.repository.TopicRepository;
import com.tfssoft.qinling.base.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private TopicAuthRepository topicAuthRepository;

	@Override
	public List<Topic> getTopicList(String name, String userId) {
		return topicRepository.getTopicList(name, userId);
	}

	@Override
	public void addTopicAuth(TopicAuth instance) {
		topicAuthRepository.addTopicAuth(instance);
	}

	@Override
	public Topic getTopicDetail(String userId, String id, String type) {
		return topicRepository.getTopicDetail(userId, id, type);
	}

	@Override
	public List<TopicAuth> getTopicAuthList(Integer skip, Integer limit, String name, String source) {
		String status = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			status = "0,1,2";
		}
		if (null == skip && null != limit) {
			return topicAuthRepository.getTopicAuthPageList(name, 0, limit.intValue(), status);
		} else if (null != skip && null == limit) {
			return topicAuthRepository.getTopicAuthPageList(name, skip.intValue(), 10, status);
		} else if (null != skip && null != limit) {
			return topicAuthRepository.getTopicAuthPageList(name, skip.intValue(), limit.intValue(), status);
		} else {
			return topicAuthRepository.getTopicAuthList(name, status);
		}
	}

	@Override
	public long getTopicAuthCount(String name, String source) {
		String status = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			status = "0,1,2";
		}
		return topicAuthRepository.getTopicAuthCount(name, status);
	}

	@Override
	public void updateTopicAuth(Integer id, String status, String comments) {
		TopicAuth instance = new TopicAuth();
		instance.setId(id);
		instance.setStatus(status);
		instance.setComments(comments);
		topicAuthRepository.updateTopicAuth(instance);
	}

	@Override
	public void deleteTopicAuthAdmin(String ids) {
		topicAuthRepository.deleteTopicAuthAdmin(ids);
	}

	@Override
	public void deleteTopicAuth(String ids) {
		topicAuthRepository.batchUpdateTopicAuth(ids, "9");
	}

}