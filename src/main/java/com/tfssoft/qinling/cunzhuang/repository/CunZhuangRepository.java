package com.tfssoft.qinling.cunzhuang.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface CunZhuangRepository {

	public List<Topic> getCunZhuangList(String name);

	public void addCunZhuang(Topic instance);

	public List<Topic> getCunZhuangPageList(String name, int skip, int limit);

	public long getCunZhuangCount(String name);
}
