package com.tfssoft.qinling.shanfeng.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface ShanFengRepository {

	public List<Topic> getShanFengList(String userId);

	public void addShanFeng(Topic instance);
}
