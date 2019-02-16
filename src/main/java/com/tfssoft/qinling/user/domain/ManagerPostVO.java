package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ManagerPostVO", description = "新增操作员VO")
public class ManagerPostVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "ID", required = false)
	private Integer id;

	@ApiModelProperty(value = "角色", required = true)
	private Integer role;
	
	@ApiModelProperty(value = "姓名", required = true)
	private String realName;
	
	@ApiModelProperty(value = "邮箱", required = true)
	private String email;
	
	@ApiModelProperty(value = "性别", required = true)
	private String sex;
	
	@ApiModelProperty(value = "密码", required = true)
	private String password;
	
	@ApiModelProperty(value = "手机号", required = false)
	private String phone;
	
	@ApiModelProperty(value = "状态", required = false)
	private String status;
	
	public ManagerPostVO() {
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}