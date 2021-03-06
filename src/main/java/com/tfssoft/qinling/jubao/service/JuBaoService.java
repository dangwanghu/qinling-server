package com.tfssoft.qinling.jubao.service;

import java.util.List;

import com.tfssoft.qinling.jubao.domain.Report;

public interface JuBaoService {
	
	public void addJuBao(Report instance);

	public List<Report> getJuBaoList(Integer skip, Integer limit, String content, String status, String source, String userId);

	public long getJuBaoCount(String content, String status, String source, String userId);

	public void updateJuBaoToHandled(int id, String comments);

	public void deleteJuBao(int id);

	public void deleteJuBaoBatch(String ids);

}
