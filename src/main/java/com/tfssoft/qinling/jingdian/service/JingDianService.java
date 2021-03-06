package com.tfssoft.qinling.jingdian.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface JingDianService {
	
	public List<Topic> getJingDianList(Integer skip, Integer limit, String name, String userId);

	public long getJingDianCount(String name);

	public void addJingDian(Topic instance);

	public void updateJingDian(Topic instance);

	public void deleteJingDian(int id);

}
