package com.tfssoft.qinling.base.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Dict;

public interface DictService {
	
	public List<Dict> getQxList();

	public List<Dict> getXzList(Integer quxian);

}
