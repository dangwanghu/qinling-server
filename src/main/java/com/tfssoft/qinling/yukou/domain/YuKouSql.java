package com.tfssoft.qinling.yukou.domain;

import com.tfssoft.qinling.base.domain.Topic;

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
	
	public static String getYuKouListSql(Integer xiangzhen, String name, String userId) {
		String conditions = "where 1 = 1 ";
		if (null != xiangzhen) {
			conditions += " and xz = " + xiangzhen;
		}
		if (null != name) {
			conditions += " and ykmc like '%" + name + "%'";
		}
		
		if (null == userId) {
			return GET_YUKOU_LIST + conditions;
		}
		String sql = "SElECT a.id, "
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
			+ "a.sjlj AS realBeautyUrl, "
			+ "1 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '1' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM yukou a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		
		return sql + conditions;
	}
	
	public static final String INSERT_YUKOU = "INSERT INTO yukou "
			+ "(ykmc, wzms, ykjj, ykrwls, ykzrfm, ykqtsm, x, y, qx, xz, sjlj) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String GET_YUKOU_COUNT = "select count(id) FROM yukou ";

	public static final String DELETE_YUKOU = "DELETE FROM yukou "
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
				instance.getTown(),
				instance.getRealBeautyUrl()
		};
	}

	public static String getYuKouPageList(Integer xiangzhen, String name, String userId, int skip, int limit) {
		String conditions = "where 1 = 1 ";
		if (null != xiangzhen) {
			conditions += " and xz = " + xiangzhen;
		}
		if (null != name) {
			conditions += " and ykmc like '%" + name + "%'";
		}
		
		if (null == userId) {
			return GET_YUKOU_LIST + conditions + " limit " + skip + "," + limit;
		}
		String sql = "SElECT a.id, "
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
			+ "a.sjlj AS realBeautyUrl, "
			+ "1 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '1' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM yukou a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		
		return sql + conditions + " limit " + skip + "," + limit;
	}
	
	public static String getCountSql(Integer xiangzhen, String name) {
		String conditions = "where 1 = 1 ";
		if (null != xiangzhen) {
			conditions += " and xz = " + xiangzhen;
		}
		if (null != name) {
			conditions += " and ykmc like '%" + name + "%'";
		}
		return GET_YUKOU_COUNT + conditions;
	}
	
	public static String getUpdateSql(Topic instance) {
		String sql = "update yukou set ykmc = '" + instance.getName() + "'";
		sql += ", wzms = '" + instance.getLocationDescription() + "'";
		sql += ", ykjj = '" + instance.getIntroduction() + "'";
		sql += ", ykrwls = '" + instance.getHistory() + "'";
		sql += ", ykzrfm = '" + instance.getNaturalFeatures() + "'";
		sql += ", ykqtsm = '" + instance.getOtherComments() + "'";
		sql += ", x = '" + instance.getxLat() + "'";
		sql += ", y = '" + instance.getyLng() + "'";
		sql += ", qx = '" + instance.getCounty() + "'";
		sql += ", xz = '" + instance.getTown() + "'";
		sql += ", sjlj = " + (instance.getRealBeautyUrl() == null ? null : ("'" + instance.getRealBeautyUrl()  + "'"));

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
