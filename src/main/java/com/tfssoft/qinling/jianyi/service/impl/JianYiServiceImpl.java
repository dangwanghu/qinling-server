package com.tfssoft.qinling.jianyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.jianyi.domain.Suggest;
import com.tfssoft.qinling.jianyi.repository.JianYiRepository;
import com.tfssoft.qinling.jianyi.service.JianYiService;


@Service
public class JianYiServiceImpl implements JianYiService {
	
	@Autowired
	private JianYiRepository jianYiRepository;

	@Override
	public void addJianYi(Suggest instance) {
		jianYiRepository.addJianYi(instance);
	}	

}