package com.tfssoft.qinling.zongjiao.domain;

public class SiMiaoSql {
	public static final String GET_SIMIAO_LIST = 
			"SElECT id, "
			+ "zjmc AS name, "
			+ "wzms AS locationDescription, "
			+ "zjjj AS introduction, "
			+ "zjrwls AS history, "
			+ "zjzrfm AS naturalFeatures, "
			+ "zjqtsm AS otherComments, "
			+ "x AS xLat, "
			+ "y AS yLng, "
			+ "qx AS county, "
			+ "xz AS town, "
			+ "yk AS yuKou "
			+ "FROM zongjiao";

}
