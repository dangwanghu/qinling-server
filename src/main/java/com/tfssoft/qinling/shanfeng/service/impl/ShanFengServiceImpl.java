package com.tfssoft.qinling.shanfeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.shanfeng.repository.ShanFengRepository;
import com.tfssoft.qinling.shanfeng.service.ShanFengService;


@Service
public class ShanFengServiceImpl implements ShanFengService {
	
	@Autowired
	private ShanFengRepository shanFengRepository;
	
	public List<Topic> getShanFengList(String userId) {
		return shanFengRepository.getShanFengList(userId);
	}	

}