package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ThirdPartyBindingVO", description = "第三方绑定VO")
public class ThirdPartyBindingVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "唯一ID", required = true)
	private String openId;
	
	@ApiModelProperty(value = "平台类型: WX 或者 QQ", required = true)
	private String openType;
	
	@ApiModelProperty(value = "用户ID", required = true)
	private Integer userId;
	
	public ThirdPartyBindingVO() {
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}