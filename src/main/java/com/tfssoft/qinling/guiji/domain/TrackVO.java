package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TrackVO", description = "轨迹VO")
public class TrackVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "轨迹标题", required = true)
	private String title;
	
	@ApiModelProperty(value = "位置点ID, 逗号隔开", required = true)
	private String points;

	@ApiModelProperty(value = "轨迹描述", required = false)
	private String description;

	@ApiModelProperty(value = "开始时间", required = true)
	private String startDate;

	@ApiModelProperty(value = "结束时间", required = true)
	private String endDate;

	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}
	
}