package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TrackVO", description = "轨迹VO")
public class TrackVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "ID", required = false)
	private Integer id;

	@ApiModelProperty(value = "轨迹标题", required = true)
	private String title;

	@ApiModelProperty(value = "轨迹描述", required = false)
	private String description;

	@ApiModelProperty(value = "开始时间", required = true)
	private Date startDate;

	@ApiModelProperty(value = "结束时间", required = true)
	private Date endDate;

	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;
	
	@ApiModelProperty(value = "图片，逗号隔开", required = true)
	private String attachments;

	public TrackVO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}