package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ManagerLoginVO", description = "操作员登录VO")
public class ManagerLoginVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "邮箱", required = true)
	private String email;
	
	@ApiModelProperty(value = "密码", required = true)
	private String password;
	
	public ManagerLoginVO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}