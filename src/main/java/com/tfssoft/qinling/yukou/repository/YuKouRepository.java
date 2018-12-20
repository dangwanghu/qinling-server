package com.tfssoft.qinling.yukou.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface YuKouRepository {

	public List<Topic> getYuKouList(Integer xiangzhen, String name, String userId);

	public void addYuKou(Topic instance);

	public List<Topic> getYuKouPageList(Integer xiangzhen, String name, String userId, int skip, int limit);

	public long getYuKouCount(Integer xiangzhen, String name);

	public void updateYuKou(Topic instance);

	public void deleteYuKou(int id);
}
