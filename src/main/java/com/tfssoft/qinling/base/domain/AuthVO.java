package com.tfssoft.qinling.base.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AuthVO", description = "审核VO")
public class AuthVO extends CommentsVO {
		
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "0-未审核 1-已通过 2-未通过", required = true)
	private String status;
	
	@ApiModelProperty(value = "专题名称")
	private String topicName;
	
	@ApiModelProperty(value = "人文地理")
	private String history;
	
	@ApiModelProperty(value = "自然风貌")
	private String naturalFeatures;
	
	@ApiModelProperty(value = "其他说明")
	private String otherComments;
	
	@ApiModelProperty(value = "纬度")
	private Double xLat;

	@ApiModelProperty(value = "经度")
	private Double yLng;

	@ApiModelProperty(value = "区县")
	private Integer county;

	@ApiModelProperty(value = "乡镇")
	private Integer town;

	@ApiModelProperty(value = "峪口")
	private Integer yuKou;
	
	@ApiModelProperty(value = "实景链接")
	private String realBeautyUrl;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getNaturalFeatures() {
		return naturalFeatures;
	}

	public void setNaturalFeatures(String naturalFeatures) {
		this.naturalFeatures = naturalFeatures;
	}

	public String getOtherComments() {
		return otherComments;
	}

	public void setOtherComments(String otherComments) {
		this.otherComments = otherComments;
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

	public Integer getCounty() {
		return county;
	}

	public void setCounty(Integer county) {
		this.county = county;
	}

	public Integer getTown() {
		return town;
	}

	public void setTown(Integer town) {
		this.town = town;
	}

	public Integer getYuKou() {
		return yuKou;
	}

	public void setYuKou(Integer yuKou) {
		this.yuKou = yuKou;
	}

	public String getRealBeautyUrl() {
		return realBeautyUrl;
	}

	public void setRealBeautyUrl(String realBeautyUrl) {
		this.realBeautyUrl = realBeautyUrl;
	}
}
