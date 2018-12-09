package com.tfssoft.qinling.zongjiao.domain;

public class SiMiaoSql {
	public static final String GET_SIMIAO_LIST = 
			"SElECT a.id, "
			+ "a.zjmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.zjjj AS introduction, "
			+ "a.zjrwls AS history, "
			+ "a.zjzrfm AS naturalFeatures, "
			+ "a.zjqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town, "
			+ "f.ykmc AS yuKou, "
			+ "a.sjlj AS realBeautyUrl "
			+ "FROM zongjiao a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz "
			+ "left join yukou f on f.id = a.yk ";
	
	public static String getSiMiaoListSql(String userId) {
		if (null == userId) {
			return GET_SIMIAO_LIST;
		}
		String sql = "SElECT a.id, "
			+ "a.zjmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.zjjj AS introduction, "
			+ "a.zjrwls AS history, "
			+ "a.zjzrfm AS naturalFeatures, "
			+ "a.zjqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town, "
			+ "f.ykmc AS yuKou, "
			+ "a.sjlj AS realBeautyUrl, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = 'ZJ' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM zongjiao a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		sql += "left join yukou f on f.id = a.yk ";
	
		return sql;
	}

}
