package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NewPasswordVO", description = "修改密码VO")
public class NewPasswordVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;
	
	@ApiModelProperty(value = "新密码", required = true)
	private String password;
	
	@ApiModelProperty(value = "原密码", required = true)
	private String oldPassword;

	public NewPasswordVO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
}