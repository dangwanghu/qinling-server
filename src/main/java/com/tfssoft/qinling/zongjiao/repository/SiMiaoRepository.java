package com.tfssoft.qinling.zongjiao.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface SiMiaoRepository {

	public List<Topic> getSiMiaoList(String userId);
}
