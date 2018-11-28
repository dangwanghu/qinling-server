package com.tfssoft.qinling.fagui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.fagui.domain.Rule;
import com.tfssoft.qinling.fagui.repository.FaGuiRepository;
import com.tfssoft.qinling.fagui.service.FaGuiService;


@Service
public class FaGuiServiceImpl implements FaGuiService {
	
	@Autowired
	private FaGuiRepository faGuiRepository;
	
	@Override
	public List<Rule> getFaGuiList(Integer skip, Integer limit, String name) {
		if (null == skip && null != limit) {
			return faGuiRepository.getFaGuiPageList(name, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return faGuiRepository.getFaGuiPageList(name, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return faGuiRepository.getFaGuiPageList(name, skip.intValue(), limit.intValue());
		} else {
			return faGuiRepository.getFaGuiList(name);
		}
	}

	@Override
	public long getFaGuiCount(String name) {
		return faGuiRepository.getCunZhuangCount(name);
	}	

}