package com.tfssoft.qinling.user.domain;

import java.io.Serializable;

public class TopicCollectVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String type;

	private String locationDescription;

	public TopicCollectVO() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}	
	
}