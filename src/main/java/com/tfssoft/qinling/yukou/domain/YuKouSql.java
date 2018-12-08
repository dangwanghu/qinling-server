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
			+ "e.xzmc AS town, "
			+ "a.sjlj AS realBeautyUrl "
			+ "FROM yukou a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz ";
	
	public static String getYuListSql(Integer xiangzhen) {
		String conditions = "";
		if (null != xiangzhen) {
			conditions += "where xz = " + xiangzhen;
		}
		return GET_YUKOU_LIST + conditions;
	}

}
