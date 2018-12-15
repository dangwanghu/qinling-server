package com.tfssoft.qinling.guiji.domain;

import java.io.Serializable;
import java.util.List;

public class TrailRedis implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Trail> vals;

	public TrailRedis() {
	}

	public List<Trail> getVals() {
		return vals;
	}

	public void setVals(List<Trail> vals) {
		this.vals = vals;
	}

}