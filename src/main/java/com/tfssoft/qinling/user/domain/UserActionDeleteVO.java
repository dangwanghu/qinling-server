package com.tfssoft.qinling.user.domain;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserActionDeleteVO", description = "用户行为删除VO")
public class UserActionDeleteVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "收藏数组，见Model注释", required = true)
	private List<UserActionPostVO> collections;

	public UserActionDeleteVO() {
	}

	public List<UserActionPostVO> getCollections() {
		return collections;
	}

	public void setCollections(List<UserActionPostVO> collections) {
		this.collections = collections;
	}
	
}