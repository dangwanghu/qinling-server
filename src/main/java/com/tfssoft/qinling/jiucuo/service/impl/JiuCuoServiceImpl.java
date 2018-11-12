package com.tfssoft.qinling.jiucuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.jiucuo.domain.Correction;
import com.tfssoft.qinling.jiucuo.repository.JiuCuoRepository;
import com.tfssoft.qinling.jiucuo.service.JiuCuoService;


@Service
public class JiuCuoServiceImpl implements JiuCuoService {
	
	@Autowired
	private JiuCuoRepository jiuCuoRepository;
	
	@Override
	public void addJiuCuo(Correction instance) {
		jiuCuoRepository.addJiuCuo(instance);
	}	

}