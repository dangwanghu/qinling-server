package com.tfssoft.qinling.jubao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.jubao.domain.Report;
import com.tfssoft.qinling.jubao.repository.JubaoRepository;
import com.tfssoft.qinling.jubao.service.JuBaoService;


@Service
public class JuBaoServiceImpl implements JuBaoService {
	
	@Autowired
	private JubaoRepository jubaoRepository;

	@Override
	public void addJuBao(Report instance) {
		jubaoRepository.addJuBao(instance);
	}	

}