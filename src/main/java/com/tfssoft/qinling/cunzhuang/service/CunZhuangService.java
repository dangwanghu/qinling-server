package com.tfssoft.qinling.cunzhuang.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface CunZhuangService {
	
	public List<Topic> getCunZhuangList(Integer skip, Integer limit, String name);

	public void addCunZhuang(Topic instance);

	public long getCunZhuangCount(String name);

	public void updateCunZhuang(Topic instance);

	public void deleteCunZhuang(int id);

}
