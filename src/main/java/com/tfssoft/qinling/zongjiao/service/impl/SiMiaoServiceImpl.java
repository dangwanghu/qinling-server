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
	
	public List<Topic> getSiMiaoList(String name, String userId, Integer skip, Integer limit) {
		if (null == skip && null != limit) {
			return siMiaoRepository.getSiMiaoPageList(name, userId, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return siMiaoRepository.getSiMiaoPageList(name, userId, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return siMiaoRepository.getSiMiaoPageList(name, userId, skip.intValue(), limit.intValue());
		} else {
			return siMiaoRepository.getSiMiaoList(name, userId);
		}
	}

	@Override
	public long getSiMiaoCount(String name) {
		return siMiaoRepository.getSiMiaoCount(name);
	}

	@Override
	public void addSiMiao(Topic instance) {
		siMiaoRepository.addSiMiao(instance);
	}

	@Override
	public void updateSiMiao(Topic instance) {
		siMiaoRepository.updateSiMiao(instance);
	}

	@Override
	public void deleteSiMiao(int id) {
		siMiaoRepository.deleteSiMiao(id);
	}	

}