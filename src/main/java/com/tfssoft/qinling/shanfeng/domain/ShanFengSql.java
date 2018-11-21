package com.tfssoft.qinling.shanfeng.domain;

public class ShanFengSql {
	public static final String GET_SHANFENG_LIST = 
			"SElECT a.id, "
			+ "a.sfmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.sfjj AS introduction, "
			+ "a.sfrwls AS history, "
			+ "a.sfzrfm AS naturalFeatures, "
			+ "a.sfqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county "
			+ "FROM shanfeng a "
			+ "left join dict_qvxian d on d.id = a.qx";

}
