package com.tfssoft.qinling.cunzhuang.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface CunZhuangRepository {

	public List<Topic> getCunZhuangList();

	public void addCunZhuang(Topic instance);
}
