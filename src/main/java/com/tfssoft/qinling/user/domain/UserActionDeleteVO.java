package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserActionDeleteVO", description = "用户行为删除VO")
public class UserActionDeleteVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "唯一ID, 逗号隔开", required = true)
	private String ids;

	public UserActionDeleteVO() {
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
}