package com.tfssoft.qinling.shanfeng.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface ShanFengRepository {

	public List<Topic> getShanFengList(String name, String userId);

	public void addShanFeng(Topic instance);

	public List<Topic> getShanFengPageList(String name, int skip, int limit, String userId);

	public long getShanFengCount(String name);

	public void updateShanFeng(Topic instance);

	public void deleteShanFeng(int id);
}
