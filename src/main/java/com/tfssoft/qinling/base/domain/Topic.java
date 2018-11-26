package com.tfssoft.qinling.base.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Topic", description = "专题")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Integer id;

	@ApiModelProperty(value = "村庄名称", required = true)
	private String name;

	@ApiModelProperty(value = "位置描述", required = true)
	private String locationDescription;

	@ApiModelProperty(value = "村庄简介", required = true)
	private String introduction;

	@ApiModelProperty(value = "人文历史", required = true)
	private String history;

	@ApiModelProperty(value = "自然风貌")
	private String naturalFeatures;

	@ApiModelProperty(value = "其他说明", required = true)
	private String otherComments;

	@ApiModelProperty(value = "纬度", required = true)
	private Double xLat;

	@ApiModelProperty(value = "经度", required = true)
	private Double yLng;

	@ApiModelProperty(value = "区县")
	private String county;

	@ApiModelProperty(value = "乡镇")
	private String town;

	@ApiModelProperty(value = "峪口")
	private String yuKou;
	
	@ApiModelProperty(hidden = true)
	private Integer type;

	public Topic() {
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getYuKou() {
		return yuKou;
	}

	public void setYuKou(String yuKou) {
		this.yuKou = yuKou;
	}

	public boolean equals(Object other) {
		Topic otherContact = (Topic) other;
		return otherContact.name.equals(this.name) && otherContact.county.equals(this.county);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}