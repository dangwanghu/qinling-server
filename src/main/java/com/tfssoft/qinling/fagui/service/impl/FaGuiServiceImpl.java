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
	
	public List<Rule> getFaGuiList() {
		return faGuiRepository.getFaGuiList();
	}	

}