package com.tfssoft.qinling.cunzhuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.cunzhuang.repository.CunZhuangRepository;
import com.tfssoft.qinling.cunzhuang.service.CunZhuangService;


@Service
public class CunZhuangServiceImpl implements CunZhuangService {
	
	@Autowired
	private CunZhuangRepository cunZhuangRepository;
	
	public List<Topic> getCunZhuangList() {
		return cunZhuangRepository.getCunZhuangList();
	}	

}