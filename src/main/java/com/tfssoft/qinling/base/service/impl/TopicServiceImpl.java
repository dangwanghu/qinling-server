package com.tfssoft.qinling.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.AuthVO;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.domain.TopicAuth;
import com.tfssoft.qinling.base.domain.TopicType;
import com.tfssoft.qinling.base.repository.TopicAuthRepository;
import com.tfssoft.qinling.base.repository.TopicRepository;
import com.tfssoft.qinling.base.repository.TopicTypeRepository;
import com.tfssoft.qinling.base.service.TopicService;
import com.tfssoft.qinling.jingdian.repository.JingDianRepository;
import com.tfssoft.qinling.shanfeng.repository.ShanFengRepository;
import com.tfssoft.qinling.yukou.repository.YuKouRepository;
import com.tfssoft.qinling.zongjiao.repository.SiMiaoRepository;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private TopicTypeRepository topicTypeRepository;

	@Autowired
	private TopicAuthRepository topicAuthRepository;

	@Autowired
	private YuKouRepository yuKouRepository;

	@Autowired
	private JingDianRepository jingDianRepository;

	@Autowired
	private ShanFengRepository shanFengRepository;

	@Autowired
	private SiMiaoRepository siMiaoRepository;

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
	public List<TopicAuth> getTopicAuthList(Integer skip, Integer limit, String name, String source, String userId,
			String status, Integer type) {
		String statusIn = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			statusIn = "0,1,2";
		}
		if (null == skip && null != limit) {
			return topicAuthRepository.getTopicAuthPageList(name, 0, limit.intValue(), statusIn, userId, status, type);
		} else if (null != skip && null == limit) {
			return topicAuthRepository.getTopicAuthPageList(name, skip.intValue(), 10, statusIn, userId, status, type);
		} else if (null != skip && null != limit) {
			return topicAuthRepository.getTopicAuthPageList(name, skip.intValue(), limit.intValue(), statusIn, userId, status, type);
		} else {
			return topicAuthRepository.getTopicAuthList(name, statusIn, userId, status, type);
		}
	}

	@Override
	public long getTopicAuthCount(String name, String source, String userId, String status, Integer type) {
		String statusIn = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			statusIn = "0,1,2";
		}
		return topicAuthRepository.getTopicAuthCount(name, statusIn, userId, status, type);
	}

	@Override
	public void updateTopicAuth(AuthVO authInstance) {
		TopicAuth instance = new TopicAuth();
		instance.setId(authInstance.getId());
		instance.setStatus(authInstance.getStatus());
		instance.setComments(authInstance.getComments());
		topicAuthRepository.updateTopicAuth(instance);

		if ("1".equals(authInstance.getStatus())) {
			TopicAuth dbInstance = topicAuthRepository.getTopicAuthById(authInstance.getId().intValue());
			Topic topic = new Topic();
			topic.setName(authInstance.getTopicName());
			topic.setLocationDescription(dbInstance.getLocationDescription());
			topic.setIntroduction(dbInstance.getIntroduction());
			topic.setHistory(authInstance.getHistory());
			topic.setNaturalFeatures(authInstance.getNaturalFeatures());
			topic.setOtherComments(authInstance.getOtherComments());
			topic.setxLat(authInstance.getxLat());
			topic.setyLng(authInstance.getyLng());
			topic.setTown(String.valueOf(authInstance.getTown()));
			topic.setCounty(String.valueOf(authInstance.getCounty()));
			topic.setYuKou(String.valueOf(authInstance.getYuKou()));
			topic.setRealBeautyUrl(authInstance.getRealBeautyUrl());

			// 5: 景点, 3: 山峰, 1: 峪口, 4: 宗教
			if ("1".equals(dbInstance.getType())) {
				yuKouRepository.addYuKou(topic);
			} else if ("3".equals(dbInstance.getType())) {
				shanFengRepository.addShanFeng(topic);
			} else if ("4".equals(dbInstance.getType())) {
				siMiaoRepository.addSiMiao(topic);
			} else if ("5".equals(dbInstance.getType())) {
				jingDianRepository.addJingDian(topic);
			}
		}
	}

	@Override
	public void deleteTopicAuthAdmin(String ids) {
		topicAuthRepository.deleteTopicAuthAdmin(ids);
	}

	@Override
	public void deleteTopicAuth(String ids) {
		topicAuthRepository.batchUpdateTopicAuth(ids, "9");
	}

	@Override
	public List<TopicType> getTopicTypeList() {
		return topicTypeRepository.getTopicTypeList();
	}

}