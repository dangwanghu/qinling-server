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
	
	@Override
	public List<Topic> getShanFengList(Integer skip, Integer limit, String name, String userId) {
		if (null == skip && null != limit) {
			return shanFengRepository.getShanFengPageList(name, 0, limit.intValue(), userId);
		} else if (null != skip && null == limit) {
			return shanFengRepository.getShanFengPageList(name, skip.intValue(), 10, userId);
		} else if (null != skip && null != limit) {
			return shanFengRepository.getShanFengPageList(name, skip.intValue(), limit.intValue(), userId);
		} else {
			return shanFengRepository.getShanFengList(name, userId);
		}
	}

	@Override
	public long getShanFengCount(String name) {
		return shanFengRepository.getShanFengCount(name);
	}

	@Override
	public void addShanFeng(Topic instance) {
		shanFengRepository.addShanFeng(instance);
	}

	@Override
	public void updateShanFeng(Topic instance) {
		shanFengRepository.updateShanFeng(instance);
	}

	@Override
	public void deleteShanFeng(int id) {
		shanFengRepository.deleteShanFeng(id);
	}	

}