package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;

public class Trail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String xLat;
	private String yLng;
	private String zHeg;
	private String time;

	public Trail() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}