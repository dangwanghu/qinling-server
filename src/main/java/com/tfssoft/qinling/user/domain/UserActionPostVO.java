package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserActionPostVO", description = "用户行为新增VO")
public class UserActionPostVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "关联专题ID", required = true)
	private Integer relId;

	@ApiModelProperty(value = "关联专题类型", required = true)
	private String relType;
	
	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;

	public UserActionPostVO() {
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}