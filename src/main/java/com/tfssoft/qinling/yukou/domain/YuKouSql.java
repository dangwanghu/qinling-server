package com.tfssoft.qinling.yukou.domain;

public class YuKouSql {
	public static final String GET_YUKOU_LIST = 
			"SElECT a.id, "
			+ "a.ykmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.ykjj AS introduction, "
			+ "a.ykrwls AS history, "
			+ "a.ykzrfm AS naturalFeatures, "
			+ "a.ykqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town "
			+ "FROM yukou a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz";

}
