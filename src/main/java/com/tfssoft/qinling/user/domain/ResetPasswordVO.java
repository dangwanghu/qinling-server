package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ResetPasswordVO", description = "重置密码VO")
public class ResetPasswordVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "手机号", required = true)
	private String phone;
	
	@ApiModelProperty(value = "新密码", required = true)
	private String password;
	
	@ApiModelProperty(value = "验证码", required = true)
	private String code;

	public ResetPasswordVO() {
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


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}