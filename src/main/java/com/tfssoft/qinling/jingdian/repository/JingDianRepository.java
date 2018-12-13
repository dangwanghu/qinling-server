package com.tfssoft.qinling.jingdian.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface JingDianRepository {

	public List<Topic> getJingDianList(String userId);

	public void addJingDian(Topic instance);
}
