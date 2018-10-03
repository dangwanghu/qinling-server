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
	
	public List<Topic> getJingDianList() {
		return jingDianRepository.getJingDianList();
	}	

}