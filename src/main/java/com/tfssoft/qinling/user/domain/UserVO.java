package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserVO", description = "用户VO")
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手机号", required = true)
	private String phone;

	@ApiModelProperty(value = "密码", required = true)
	private String password;

	public UserVO() {
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}