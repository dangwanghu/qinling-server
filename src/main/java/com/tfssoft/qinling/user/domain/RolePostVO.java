package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RolePostVO", description = "新增角色VO")
public class RolePostVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "ID", required = false)
	private Integer id;
	
	@ApiModelProperty(value = "角色名称", required = true)
	private String name;
	
	@ApiModelProperty(value = "权限字符串", required = true)
	private String scope;
	
	@ApiModelProperty(value = "角色状态", required = false)
	private Integer status;
	
	public RolePostVO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}