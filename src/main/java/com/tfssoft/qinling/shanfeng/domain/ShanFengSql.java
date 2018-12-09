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
			+ "d.qxmc AS county, " 
			+ "a.sjlj AS realBeautyUrl "
			+ "FROM shanfeng a "
			+ "left join dict_qvxian d on d.id = a.qx";
	
	public static String getShanFengListSql(String userId) {
		if (null == userId) {
			return GET_SHANFENG_LIST;
		}
		String sql = "SElECT a.id, "
			+ "a.sfmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.sfjj AS introduction, "
			+ "a.sfrwls AS history, "
			+ "a.sfzrfm AS naturalFeatures, "
			+ "a.sfqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, " 
			+ "a.sjlj AS realBeautyUrl, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = 'SF' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM shanfeng a ";
		sql += "left join dict_qvxian d on d.id = a.qx";
		
		return sql;
	}

}
