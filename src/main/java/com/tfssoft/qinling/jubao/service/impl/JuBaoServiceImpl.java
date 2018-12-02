package com.tfssoft.qinling.jubao.service.impl;

import java.util.List;

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
	
	@Override
	public List<Report> getJuBaoList(Integer skip, Integer limit, String content) {
		if (null == skip && null != limit) {
			return jubaoRepository.getJuBaoPageList(content, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return jubaoRepository.getJuBaoPageList(content, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return jubaoRepository.getJuBaoPageList(content, skip.intValue(), limit.intValue());
		} else {
			return jubaoRepository.getJuBaoList(content);
		}
	}

	@Override
	public long getJuBaoCount(String content) {
		return jubaoRepository.getJuBaoCount(content);
	}

	@Override
	public void updateJuBaoToHandled(int id) {
		Report instance = new Report();
		instance.setId(id);
		instance.setStatus("1");
		jubaoRepository.updateJuBao(instance);
	}

	@Override
	public void deleteJuBao(int id) {
		jubaoRepository.deleteJuBao(id);
	}	

}