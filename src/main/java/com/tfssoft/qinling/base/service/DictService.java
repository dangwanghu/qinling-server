package com.tfssoft.qinling.base.service;

import java.util.List;

import com.tfssoft.qinling.base.domain.Dict;
import com.tfssoft.qinling.base.domain.ResourceTree;

public interface DictService {
	
	public List<Dict> getQxList();

	public List<Dict> getXzList(Integer quxian);

	public List<ResourceTree> getResources(Integer parentId);

}
