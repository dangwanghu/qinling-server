package com.tfssoft.qinling.jingdian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.jingdian.repository.JingDianRepository;
import com.tfssoft.qinling.jingdian.service.JingDianService;


@Service
public class JingDianServiceImpl implements JingDianService {
	
	@Autowired
	private JingDianRepository jingDianRepository;
	
	public List<Topic> getJingDianList(Integer skip, Integer limit, String name, String userId) {
		if (null == skip && null != limit) {
			return jingDianRepository.getJingDianPageList(name, 0, limit.intValue(), userId);
		} else if (null != skip && null == limit) {
			return jingDianRepository.getJingDianPageList(name, skip.intValue(), 10, userId);
		} else if (null != skip && null != limit) {
			return jingDianRepository.getJingDianPageList(name, skip.intValue(), limit.intValue(), userId);
		} else {
			return jingDianRepository.getJingDianList(name, userId);
		}
	}

	@Override
	public long getJingDianCount(String name) {
		return jingDianRepository.getJingDianCount(name);
	}

	@Override
	public void addJingDian(Topic instance) {
		jingDianRepository.addJingDian(instance);
	}

	@Override
	public void updateJingDian(Topic instance) {
		jingDianRepository.updateJingDian(instance);
	}

	@Override
	public void deleteJingDian(int id) {
		jingDianRepository.deleteJingDian(id);
	}	

}