package com.tfssoft.qinling.zongjiao.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface SiMiaoService {
	
	public List<Topic> getSiMiaoList(String name, String userId, Integer skip, Integer limit);

	public long getSiMiaoCount(String name);

	public void addSiMiao(Topic instance);

	public void updateSiMiao(Topic instance);

	public void deleteSiMiao(int id);

}
