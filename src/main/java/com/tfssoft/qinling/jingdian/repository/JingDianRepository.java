package com.tfssoft.qinling.jingdian.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface JingDianRepository {

	public List<Topic> getJingDianList(String name, String userId);

	public void addJingDian(Topic instance);

	public List<Topic> getJingDianPageList(String name, int skip, int limit, String userId);

	public long getJingDianCount(String name);

	public void updateJingDian(Topic instance);

	public void deleteJingDian(int id);
}
