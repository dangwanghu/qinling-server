package com.tfssoft.qinling.base.repository;

import java.util.List;

import com.tfssoft.qinling.base.domain.Resource;

public interface ResourceRepository {

	List<Resource> getResourceByLevel(Integer level);
	
}
