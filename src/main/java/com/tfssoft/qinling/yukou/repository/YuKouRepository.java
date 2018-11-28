package com.tfssoft.qinling.yukou.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface YuKouRepository {

	public List<Topic> getYuKouList(Integer xiangzhen);
}
