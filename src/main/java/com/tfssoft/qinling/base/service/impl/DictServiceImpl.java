package com.tfssoft.qinling.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Dict;
import com.tfssoft.qinling.base.repository.DictRepository;
import com.tfssoft.qinling.base.service.DictService;


@Service
public class DictServiceImpl implements DictService {
	
	@Autowired
	private DictRepository dictRepository;

	@Override
	public List<Dict> getQxList() {
		return dictRepository.getQxList();
	}

	@Override
	public List<Dict> getXzList(Integer quxian) {
		return dictRepository.getXzList(quxian);
	}

}