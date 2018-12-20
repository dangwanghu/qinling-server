package com.tfssoft.qinling.yukou.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface YuKouService {
	
	public List<Topic> getYuKouList(Integer xiangzhen, String name, String userId, Integer skip, Integer limit);

	public long getYuKouCount(Integer xiangzhen, String name);

	public void addYuKou(Topic instance);

	public void updateYuKou(Topic instance);

	public void deleteYuKou(int id);

}
