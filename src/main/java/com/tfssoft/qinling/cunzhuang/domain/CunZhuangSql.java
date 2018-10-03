package com.tfssoft.qinling.cunzhuang.domain;

public class CunZhuangSql {
	public static final String GET_CUNZHUANG_LIST = 
			"SElECT id, "
			+ "czmc AS name, "
			+ "wzms AS locationDescription, "
			+ "czjj AS introduction, "
			+ "czrwls AS history, "
			+ "czqtsm AS otherComments, "
			+ "x AS xLat, "
			+ "y AS yLng, "
			+ "qx AS county, "
			+ "xz AS town, "
			+ "yk AS yuKou "
			+ "FROM cunzhuang";

}
