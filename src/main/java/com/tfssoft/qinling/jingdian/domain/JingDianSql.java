package com.tfssoft.qinling.jingdian.domain;

public class JingDianSql {
	public static final String GET_JINGDIAN_LIST = 
			"SElECT a.id, "
			+ "a.jdmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.jdjj AS introduction, "
			+ "a.jdrwls AS history, "
			+ "a.jdzrfm AS naturalFeatures, "
			+ "a.jdqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town, "
			+ "f.ykmc AS yuKou "
			+ "FROM jingdian a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz "
			+ "left join yukou f on f.id = a.yk ";

}
