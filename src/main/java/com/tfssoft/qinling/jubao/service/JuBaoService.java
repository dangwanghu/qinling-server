package com.tfssoft.qinling.jubao.service;

import java.util.List;

import com.tfssoft.qinling.jubao.domain.Report;

public interface JuBaoService {
	
	public void addJuBao(Report instance);

	public List<Report> getJuBaoList(Integer skip, Integer limit, String content);

	public long getJuBaoCount(String content);

	public void updateJuBaoToHandled(int id);

	public void deleteJuBao(int id);

}
