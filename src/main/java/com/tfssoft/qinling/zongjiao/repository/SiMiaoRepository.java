package com.tfssoft.qinling.zongjiao.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface SiMiaoRepository {

	public List<Topic> getSiMiaoList(String name, String userId);

	public void addSiMiao(Topic instance);

	public List<Topic> getSiMiaoPageList(String name, String userId, int skip, int limit);

	public long getSiMiaoCount(String name);

	public void updateSiMiao(Topic instance);

	public void deleteSiMiao(int id);
}
