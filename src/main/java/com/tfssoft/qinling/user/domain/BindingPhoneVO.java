package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BindingPhoneVO", description = "绑定手机VO")
public class BindingPhoneVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手机号", required = true)
	private String phone;

	@ApiModelProperty(value = "用户ID", required = true)
	private Integer userId;
	
	@ApiModelProperty(value = "验证码", required = true)
	private String code;

	public BindingPhoneVO() {
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}