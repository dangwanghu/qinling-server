package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserPutVO", description = "用户PUT VO")
public class UserPutVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID", required = true)
	private Integer id;
	
	@ApiModelProperty(value = "状态", required = true)
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
