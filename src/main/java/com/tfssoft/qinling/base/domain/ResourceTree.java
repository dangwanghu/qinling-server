package com.tfssoft.qinling.base.domain;

import java.io.Serializable;
import java.util.List;

public class ResourceTree implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String label;
	private String code;
	private List<ResourceTree> children;
	private Boolean isLeaf;
	
	public ResourceTree() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<ResourceTree> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceTree> children) {
		this.children = children;
	}

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}