package com.tfssoft.qinling.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.repository.TopicRepository;
import com.tfssoft.qinling.base.service.TopicService;


@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getTopicList(String name) {
		return topicRepository.getTopicList(name);
	}

}