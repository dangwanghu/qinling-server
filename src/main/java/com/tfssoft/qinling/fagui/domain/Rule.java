package com.tfssoft.qinling.fagui.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Rule", description = "法规")
public class Rule implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Integer id;

	@ApiModelProperty(value = "法规名称", required = true)
	private String name;

	@ApiModelProperty(value = "发布单位", required = true)
	private String publishUnit;

	@ApiModelProperty(hidden = true)
	private String publishTime;

	@ApiModelProperty(value = "实施时间", required = true)
	private String implementTime;

	@ApiModelProperty(value = "链接地址", required = true)
	private String url;

	@ApiModelProperty(value = "链接类型", required = true)
	private Integer urlType;

	@ApiModelProperty(value = "其他说明: urlType=0 表示url为互联网链接", required = true)
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