package com.tfssoft.qinling.cunzhuang.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Topic;

public interface CunZhuangService {
	
	public List<Topic> getCunZhuangList();

	public void addCunZhuang(Topic instance);

}
