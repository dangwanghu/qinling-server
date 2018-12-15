package com.tfssoft.qinling.jubao.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Report", description = "举报")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Integer id;

	@ApiModelProperty(value = "举报内容", required = true)
	private String content;
	
	@ApiModelProperty(value = "附件信息, 逗号分隔")
	private String attachments;

	@ApiModelProperty(value = "提交人", required = true)
	private String submitter;

	@ApiModelProperty(value = "联系方式", required = true)
	private String phone;

	@ApiModelProperty(hidden = true)
	private Date createTime;

	@ApiModelProperty(hidden = true)
	private String status;
	
	@ApiModelProperty(hidden = true)
	private Date updateTime;
	
	@ApiModelProperty(hidden = true)
	private String comments;
	
	@ApiModelProperty(value = "纬度", required = true)
	private Double xLat;

	@ApiModelProperty(value = "经度", required = true)
	private Double yLng;
	
	@ApiModelProperty(value = "地址", required = false)
	private String address;
	
	@ApiModelProperty(value = "原因", required = false)
	private String reason;
	
	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;
	
	public Report() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
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

	public Double getxLat() {
		return xLat;
	}

	public void setxLat(Double xLat) {
		this.xLat = xLat;
	}

	public Double getyLng() {
		return yLng;
	}

	public void setyLng(Double yLng) {
		this.yLng = yLng;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}