package com.tfssoft.qinling.fagui.domain;

import java.io.Serializable;

public class Rule implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String publishUnit;

	private String publishTime;

	private String implementTime;

	private String url;

	private Integer urlType;

	private String urlTypeDescription;

	public Rule() {
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

	public String getPublishUnit() {
		return publishUnit;
	}

	public void setPublishUnit(String publishUnit) {
		this.publishUnit = publishUnit;
	}

	public String getPublishTime() {
		return publishTime;
	}
	
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getImplementTime() {
		return implementTime;
	}

	public void setImplementTime(String implementTime) {
		this.implementTime = implementTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUrlType() {
		return urlType;
	}

	public void setUrlType(Integer urlType) {
		this.urlType = urlType;
	}

	public String getUrlTypeDescription() {
		return urlTypeDescription;
	}

	public void setUrlTypeDescription(String urlTypeDescription) {
		this.urlTypeDescription = urlTypeDescription;
	}

	public boolean equals(Object other) {
		Rule otherContact = (Rule) other;
		return otherContact.name.equals(this.name) && otherContact.url.equals(this.url);
	}

	public int hashCode() {
		return name.hashCode();
	}
}