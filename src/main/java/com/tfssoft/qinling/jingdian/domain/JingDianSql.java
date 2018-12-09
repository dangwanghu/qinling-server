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
			+ "f.ykmc AS yuKou, "
			+ "a.sjlj AS realBeautyUrl "
			+ "FROM jingdian a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz "
			+ "left join yukou f on f.id = a.yk ";

	public static String getJingDianListSql(String userId) {
		if (null == userId) {
			return GET_JINGDIAN_LIST;
		}
		String sql = "SElECT a.id, "
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
			+ "f.ykmc AS yuKou, "
			+ "a.sjlj AS realBeautyUrl, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = 'JD' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM jingdian a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		sql += "left join yukou f on f.id = a.yk ";
		return sql;
	}

}
