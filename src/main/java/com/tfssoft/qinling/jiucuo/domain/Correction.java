package com.tfssoft.qinling.jiucuo.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Correction", description = "纠错")
public class Correction implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Integer id;

	@ApiModelProperty(value = "专题类别, 6: 村庄, 5: 景点, 3: 山峰, 1: 峪口, 4: 宗教", required = true)
	private String type;

	@ApiModelProperty(value = "关联专题ID", required = true)
	private Integer relId;

	@ApiModelProperty(value = "建议内容", required = true)
	private String content;

	@ApiModelProperty(value = "提交人", required = true)
	private String submitter;

	@ApiModelProperty(value = "联系方式", required = true)
	private String phone;

	@ApiModelProperty(hidden = true)
	private Date createTime;

	@ApiModelProperty(hidden = true)
	private String status;
	
	@ApiModelProperty(hidden = true)
	private String subjectName;
	
	@ApiModelProperty(hidden = true)
	private Date updateTime;
	
	@ApiModelProperty(hidden = true)
	private String comments;
	
	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;

	public Correction() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}