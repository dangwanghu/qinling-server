package com.tfssoft.qinling.jiucuo.repository;

import java.util.List;

import com.tfssoft.qinling.jiucuo.domain.Correction;

public interface JiuCuoRepository {

	public void addJiuCuo(Correction instance);

	public List<Correction> getJiuCuoPageList(String content, int skip, int limit);

	public List<Correction> getJiuCuoList(String content);

	public long getJiuCuoCount(String content);

	public void updateJiuCuo(Correction instance);

	public void deleteJiuCuo(int id);
}
