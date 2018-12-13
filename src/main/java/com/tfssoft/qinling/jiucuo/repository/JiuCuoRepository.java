package com.tfssoft.qinling.jiucuo.repository;

import java.util.List;

import com.tfssoft.qinling.jiucuo.domain.Correction;

public interface JiuCuoRepository {

	public void addJiuCuo(Correction instance);

	public List<Correction> getJiuCuoPageList(String content, int skip, int limit, String status);

	public List<Correction> getJiuCuoList(String content, String status);

	public long getJiuCuoCount(String content, String status);

	public void updateJiuCuo(Correction instance);

	public void deleteJiuCuo(int id);

	public void updateJiuCuoBatch(String ids, String status);
}
