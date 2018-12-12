package com.tfssoft.qinling.base.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TopicAuth", description = "专题审核")
public class TopicAuth implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Integer id;
	
	@ApiModelProperty(value = "添加原因", required = true)
	private String reason;
	
	@ApiModelProperty(value = "专题类别, 5: 景点, 3: 山峰, 1: 峪口, 4: 宗教", required = true)
	private String topicType;

	@ApiModelProperty(value = "位置描述", required = true)
	private String locationDescription;

	@ApiModelProperty(value = "简介", required = true)
	private String introduction;

	@ApiModelProperty(value = "纬度", required = true)
	private Double xLat;

	@ApiModelProperty(value = "经度", required = true)
	private Double yLng;
	
	@ApiModelProperty(value = "图片附件", required = false)
	private String attachments;
	
	@ApiModelProperty(value = "0-未审核 1-已通过 2-未通过", hidden = true)
	private String status;
	
	@ApiModelProperty(hidden = true)
	private String createTime;

	@ApiModelProperty(hidden = true)
	private String updateTime;
	
	@ApiModelProperty(hidden = true)
	private String comments;

	public TopicAuth() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}