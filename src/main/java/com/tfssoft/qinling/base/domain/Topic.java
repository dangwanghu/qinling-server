package com.tfssoft.qinling.base.domain;

import java.io.Serializable;

public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String locationDescription;

	private String introduction;

	private String history;

	private String naturalFeatures;

	private String otherComments;

	private Double xLat;

	private Double yLng;

	private String county;

	private String town;

	private String yuKou;

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
}