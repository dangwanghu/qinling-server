package com.tfssoft.qinling.zongjiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.zongjiao.repository.SiMiaoRepository;
import com.tfssoft.qinling.zongjiao.service.SiMiaoService;


@Service
public class SiMiaoServiceImpl implements SiMiaoService {
	
	@Autowired
	private SiMiaoRepository siMiaoRepository;
	
	public List<Topic> getSiMiaoList(String userId) {
		return siMiaoRepository.getSiMiaoList(userId);
	}	

}