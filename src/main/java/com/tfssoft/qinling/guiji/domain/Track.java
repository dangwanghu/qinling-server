package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;
import java.util.List;

public class Track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private List<Trail> points;
	private String pointIds;

	public Track() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Trail> getPoints() {
		return points;
	}

	public void setPoints(List<Trail> points) {
		this.points = points;
	}

	public String getPointIds() {
		return pointIds;
	}

	public void setPointIds(String pointIds) {
		this.pointIds = pointIds;
	}

}