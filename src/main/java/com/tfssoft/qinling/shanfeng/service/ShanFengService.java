package com.tfssoft.qinling.shanfeng.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface ShanFengService {
	
	public List<Topic> getShanFengList(Integer skip, Integer limit, String name, String userId);

	public long getShanFengCount(String name);

	public void addShanFeng(Topic instance);

	public void updateShanFeng(Topic instance);

	public void deleteShanFeng(int id);

}
