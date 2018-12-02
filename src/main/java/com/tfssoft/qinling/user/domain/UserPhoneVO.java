package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserPhoneVO", description = "手机登录VO")
public class UserPhoneVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手机号", required = true)
	private String phone;
	
	@ApiModelProperty(value = "验证码", required = true)
	private String code;

	public UserPhoneVO() {
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}