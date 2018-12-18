package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userId;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private List<Trail> points;
	private String attachments;

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

	public List<Trail> getPoints() {
		return points;
	}

	public void setPoints(List<Trail> points) {
		this.points = points;
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

}