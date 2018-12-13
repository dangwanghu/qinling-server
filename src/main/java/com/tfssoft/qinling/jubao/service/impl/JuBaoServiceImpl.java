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
	public List<Report> getJuBaoList(Integer skip, Integer limit, String content, String status, String source,
			String userId) {
		String statusIn = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			statusIn = "0,1,2";
		}
		if (null == skip && null != limit) {
			return jubaoRepository.getJuBaoPageList(content, 0, limit.intValue(), status, statusIn, userId);
		} else if (null != skip && null == limit) {
			return jubaoRepository.getJuBaoPageList(content, skip.intValue(), 10, status, statusIn, userId);
		} else if (null != skip && null != limit) {
			return jubaoRepository.getJuBaoPageList(content, skip.intValue(), limit.intValue(), status, statusIn, userId);
		} else {
			return jubaoRepository.getJuBaoList(content, status, statusIn, userId);
		}
	}

	@Override
	public long getJuBaoCount(String content, String status, String source,
			String userId) {
		String statusIn = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			statusIn = "0,1,2";
		}
		return jubaoRepository.getJuBaoCount(content, status, statusIn, userId);
	}

	@Override
	public void updateJuBaoToHandled(int id, String comments) {
		Report instance = new Report();
		instance.setId(id);
		instance.setStatus("1");
		instance.setComments(comments);
		jubaoRepository.updateJuBao(instance);
	}

	@Override
	public void deleteJuBao(int id) {
		jubaoRepository.deleteJuBao(id);
	}

	@Override
	public void deleteJuBaoBatch(String ids) {
		jubaoRepository.updateJuBaoBatch(ids, "9");
	}	

}