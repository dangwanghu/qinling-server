package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TrailVO", description = "轨迹点VO")
public class TrailVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;

	@ApiModelProperty(value = "纬度", required = true)
	private String xLat;

	@ApiModelProperty(value = "经度", required = true)
	private String yLng;

	@ApiModelProperty(value = "高程", required = false)
	private String zHeg;

	public TrailVO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getxLat() {
		return xLat;
	}

	public void setxLat(String xLat) {
		this.xLat = xLat;
	}

	public String getyLng() {
		return yLng;
	}

	public void setyLng(String yLng) {
		this.yLng = yLng;
	}

	public String getzHeg() {
		return zHeg;
	}

	public void setzHeg(String zHeg) {
		this.zHeg = zHeg;
	}
	
}