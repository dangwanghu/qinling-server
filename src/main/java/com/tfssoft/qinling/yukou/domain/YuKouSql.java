package com.tfssoft.qinling.yukou.domain;

public class YuKouSql {
	public static final String GET_YUKOU_LIST = 
			"SElECT id, "
			+ "ykmc AS name, "
			+ "wzms AS locationDescription, "
			+ "ykjj AS introduction, "
			+ "ykrwls AS history, "
			+ "ykzrfm AS naturalFeatures, "
			+ "ykqtsm AS otherComments, "
			+ "x AS xLat, "
			+ "y AS yLng, "
			+ "qx AS county, "
			+ "xz AS town "
			+ "FROM yukou";

}
