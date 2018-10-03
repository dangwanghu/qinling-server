package com.tfssoft.qinling.jingdian.domain;

public class JingDianSql {
	public static final String GET_JINGDIAN_LIST = 
			"SElECT id, "
			+ "jdmc AS name, "
			+ "wzms AS locationDescription, "
			+ "jdjj AS introduction, "
			+ "jdrwls AS history, "
			+ "jdzrfm AS naturalFeatures, "
			+ "jdqtsm AS otherComments, "
			+ "x AS xLat, "
			+ "y AS yLng, "
			+ "qx AS county, "
			+ "xz AS town, "
			+ "yk AS yuKou "
			+ "FROM jingdian";

}
