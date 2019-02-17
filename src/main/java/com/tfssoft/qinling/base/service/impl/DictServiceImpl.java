package com.tfssoft.qinling.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Dict;
import com.tfssoft.qinling.base.domain.Resource;
import com.tfssoft.qinling.base.domain.ResourceTree;
import com.tfssoft.qinling.base.repository.DictRepository;
import com.tfssoft.qinling.base.repository.ResourceRepository;
import com.tfssoft.qinling.base.service.DictService;


@Service
public class DictServiceImpl implements DictService {
	
	@Autowired
	private DictRepository dictRepository;

	@Autowired
	private ResourceRepository resourceRepository;
	
	@Override
	public List<Dict> getQxList() {
		return dictRepository.getQxList();
	}

	@Override
	public List<Dict> getXzList(Integer quxian) {
		return dictRepository.getXzList(quxian);
	}

	@Override
	public List<ResourceTree> getResources(Integer parentId) {
		List<ResourceTree> result = new ArrayList<ResourceTree>();
				
		List<Resource> childLevel0Nodes = resourceRepository.getResourceByLevel(0);
		List<Resource> childLevel1Nodes = resourceRepository.getResourceByLevel(1);
		List<Resource> childLevel2Nodes = resourceRepository.getResourceByLevel(2);
		
		// 0, 1
		for (Resource resource : childLevel0Nodes) {
			ResourceTree node = new ResourceTree();
			node.setId(resource.getId());
			node.setLabel(resource.getName());
			List<ResourceTree> childs = new ArrayList<ResourceTree>();
			
			for (Resource resourceLVL1 : childLevel1Nodes) {
				if (resourceLVL1.getParentId().equals(resource.getId())) {
					ResourceTree nodeLVL1 = new ResourceTree();
					nodeLVL1.setId(resourceLVL1.getId());
					nodeLVL1.setLabel(resourceLVL1.getName());
					childs.add(nodeLVL1);
				}
			}
			
			if (childs.size() > 0) {
				node.setChildren(childs);
				node.setIsLeaf(false);
			} else {
				node.setIsLeaf(true);
			}
			
			result.add(node);
		}
		
		// 2
		for (ResourceTree resourceTree : result) {
			List<ResourceTree> resultLVL1 = resourceTree.getChildren();
			
			for (ResourceTree nodeLVL1 : resultLVL1) {
				
				List<ResourceTree> childs = new ArrayList<ResourceTree>();
				
				for (Resource resourceLVL2 : childLevel2Nodes) {
					if (resourceLVL2.getParentId().equals(nodeLVL1.getId())) {
						ResourceTree nodeLVL2 = new ResourceTree();
						nodeLVL2.setId(resourceLVL2.getId());
						nodeLVL2.setLabel(resourceLVL2.getName());
						nodeLVL2.setIsLeaf(true);
						childs.add(nodeLVL2);
					}
				}
				
				if (childs.size() > 0) {
					nodeLVL1.setChildren(childs);
					nodeLVL1.setIsLeaf(false);
				} else {
					nodeLVL1.setIsLeaf(true);
				}
			}
			
		}
		
		return result;
	}

}