package com.tfssoft.qinling.shanfeng.domain;

public class ShanFengSql {
	public static final String GET_SHANFENG_LIST = 
			"SElECT id, "
			+ "sfmc AS name, "
			+ "wzms AS locationDescription, "
			+ "sfjj AS introduction, "
			+ "sfrwls AS history, "
			+ "sfzrfm AS naturalFeatures, "
			+ "sfqtsm AS otherComments, "
			+ "x AS xLat, "
			+ "y AS yLng, "
			+ "qx AS county "
			+ "FROM shanfeng";

}
