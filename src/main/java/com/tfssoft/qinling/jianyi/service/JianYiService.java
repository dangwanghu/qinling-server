package com.tfssoft.qinling.jianyi.service;

import java.util.List;

import com.tfssoft.qinling.jianyi.domain.Suggest;

public interface JianYiService {
	
	public void addJianYi(Suggest instance);

	public List<Suggest> getJianYiList(Integer skip, Integer limit, String content);

	public long getJianYiCount(String content);

	public void updateJianYiToHandled(int id);

	public void deleteJianYi(int id);

}
