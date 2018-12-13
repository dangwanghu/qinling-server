package com.tfssoft.qinling.jianyi.service;

import java.util.List;

import com.tfssoft.qinling.jianyi.domain.Suggest;

public interface JianYiService {
	
	public void addJianYi(Suggest instance);

	public List<Suggest> getJianYiList(Integer skip, Integer limit, String content, String status);

	public long getJianYiCount(String content, String status);

	public void updateJianYiToHandled(int id, String comments);

	public void deleteJianYi(int id);

	public void deleteJianYiBatch(String ids);

}
