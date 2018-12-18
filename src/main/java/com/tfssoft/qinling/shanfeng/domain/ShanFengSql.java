package com.tfssoft.qinling.shanfeng.domain;

import com.tfssoft.qinling.base.domain.Topic;

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
	
	public static String getListSql(String name, String userId) {
		String conditions = "";
		if (null != name) {
			conditions += " where sfmc like '%" + name + "%'";
		}
		if (null == userId) {
			return GET_SHANFENG_LIST + conditions;
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
			+ "3 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '3' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM shanfeng a ";
		sql += "left join dict_qvxian d on d.id = a.qx";
		
		return sql + conditions;
	}
	
	public static final String INSERT_SHANFENG = "INSERT INTO shanfeng "
			+ "(sfmc, wzms, sfjj, sfrwls, sfzrfm, sfqtsm, x, y, qx, sjlj) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_SHANFENG_COUNT = "select count(id) from shanfeng ";
	
	public static final String DELETE_SHANFENG = "DELETE FROM shanfeng "
			+ "where id = ?";

	public static Object[] getInsertObject(Topic instance) {
		return new Object[] {
				instance.getName(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getHistory(),
				instance.getNaturalFeatures(),
				instance.getOtherComments(),
				instance.getxLat(),
				instance.getyLng(),
				instance.getCounty(),
				instance.getRealBeautyUrl()
		};
	}

	public static String getPageListSql(String name, int skip, int limit, String userId) {
		String conditions = "";
		if (null != name) {
			conditions += " where sfmc like '%" + name + "%'";
		}
		if (null == userId) {
			return GET_SHANFENG_LIST + conditions;
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
			+ "3 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '3' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM shanfeng a ";
		sql += "left join dict_qvxian d on d.id = a.qx";
		
		return sql + conditions + " limit " + skip + "," + limit;
	}

	public static String getCountSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += " where sfmc like '%" + name + "%'";
		}
		return GET_SHANFENG_COUNT + conditions;
	}

	public static String getUpdateSql(Topic instance) {
		String sql = "update shanfeng set sfmc = '" + instance.getName() + "'";
		sql += ", wzms = '" + instance.getLocationDescription() + "'";
		sql += ", sfjj = '" + instance.getIntroduction() + "'";
		sql += ", sfrwls = '" + instance.getHistory() + "'";
		sql += ", sfzrfm = '" + instance.getNaturalFeatures() + "'";
		sql += ", sfqtsm = '" + instance.getOtherComments() + "'";
		sql += ", x = '" + instance.getxLat() + "'";
		sql += ", y = '" + instance.getyLng() + "'";
		sql += ", qx = '" + instance.getCounty() + "'";
		sql += ", sjlj = '" + instance.getRealBeautyUrl() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
