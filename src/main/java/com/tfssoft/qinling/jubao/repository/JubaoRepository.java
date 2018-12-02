package com.tfssoft.qinling.jubao.repository;

import java.util.List;

import com.tfssoft.qinling.jubao.domain.Report;

public interface JubaoRepository {

	public void addJuBao(Report instance);

	public List<Report> getJuBaoPageList(String content, int skip, int limit);

	public List<Report> getJuBaoList(String content);

	public long getJuBaoCount(String content);

	public void updateJuBao(Report instance);

	public void deleteJuBao(int id);
}
