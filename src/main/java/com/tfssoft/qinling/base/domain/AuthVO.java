package com.tfssoft.qinling.base.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AuthVO", description = "审核VO")
public class AuthVO extends CommentsVO {
		
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "0-未审核 1-已通过 2-未通过", required = true)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
