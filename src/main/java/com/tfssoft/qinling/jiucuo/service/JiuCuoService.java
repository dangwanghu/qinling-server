package com.tfssoft.qinling.jiucuo.service;

import java.util.List;

import com.tfssoft.qinling.jiucuo.domain.Correction;

public interface JiuCuoService {
	
	public void addJiuCuo(Correction instance);

	public List<Correction> getJiuCuoList(Integer skip, Integer limit, String content, String status, String source, String userId);

	public long getJiuCuoCount(String content, String status, String source, String userId);

	public void updateJiuCuoToHandled(int id, String comments);

	public void deleteJiuCuo(int id);

	public void deleteJiuCuoBatch(String ids);

}
