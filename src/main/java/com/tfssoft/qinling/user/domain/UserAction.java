package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserAction", description = "用户行为VO")
public class UserAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Integer id;
	
	@ApiModelProperty(value = "关联专题ID", required = true)
	private Integer relId;

	@ApiModelProperty(value = "关联专题类型: 5: 景点, 3: 山峰, 1: 峪口, 4: 宗教", required = true)
	private String relType;
	
	@ApiModelProperty(hidden = true)
	private String relName;
	
	@ApiModelProperty(hidden = true)
	private String address;
	
	@ApiModelProperty(hidden = true)
	private String createTime;

	public UserAction() {
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public String getRelName() {
		return relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}