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
	
	public List<Topic> getCunZhuangList(Integer skip, Integer limit, String name) {
		if (null == skip && null != limit) {
			return cunZhuangRepository.getCunZhuangPageList(name, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return cunZhuangRepository.getCunZhuangPageList(name, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return cunZhuangRepository.getCunZhuangPageList(name, skip.intValue(), limit.intValue());
		} else {
			return cunZhuangRepository.getCunZhuangList(name);
		}
	}

	@Override
	public void addCunZhuang(Topic instance) {
		cunZhuangRepository.addCunZhuang(instance);
	}

	@Override
	public long getCunZhuangCount(String name) {
		return cunZhuangRepository.getCunZhuangCount(name);

	}

	@Override
	public void updateCunZhuang(Topic instance) {
		cunZhuangRepository.updateCunZhuang(instance);
	}

	@Override
	public void deleteCunZhuang(int id) {
		cunZhuangRepository.deleteCunZhuang(id);
	}	

}