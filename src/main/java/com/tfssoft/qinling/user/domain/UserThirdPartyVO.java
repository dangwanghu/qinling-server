package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserThirdPartyVO", description = "第三方用户VO")
public class UserThirdPartyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "唯一ID", required = true)
	private String openId;
	
	@ApiModelProperty(value = "平台类型: WX, QQ", required = true)
	private String openType;
	
	@ApiModelProperty(value = "昵称", required = false)
	private String nickName;
	
	@ApiModelProperty(value = "头像", required = false)
	private String avatar;
	
	@ApiModelProperty(value = "性别: M, F", required = false)
	private String sex;

	public UserThirdPartyVO() {
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}