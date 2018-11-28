package com.tfssoft.qinling.base.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Dict;

public interface DictRepository {

	public List<Dict> getQxList();

	public List<Dict> getXzList(Integer quxian);
}
