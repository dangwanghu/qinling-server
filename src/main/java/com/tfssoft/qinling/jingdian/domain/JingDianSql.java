package com.tfssoft.qinling.jingdian.domain;

import com.tfssoft.qinling.base.domain.Topic;

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
	
	public static final String GET_JINGDIAN_COUNT = "SElECT count(id) FROM jingdian ";

	public static String getListSql(String name, String userId) {
		String conditions = "";
		if (null != name) {
			conditions += " where jdmc like '%" + name + "%'";
		}
		if (null == userId) {
			return GET_JINGDIAN_LIST + conditions;
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
			+ "5 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '5' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM jingdian a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		sql += "left join yukou f on f.id = a.yk ";
		return sql + conditions;
	}

	public static final String INSERT_JINGDIAN = "INSERT INTO jingdian "
			+ "(jdmc, wzms, jdjj, jdrwls, jdzrfm, jdqtsm, x, y, qx, xz, yk, sjlj) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String DELETE_JINGDIAN = "DELETE FROM jingdian "
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
				instance.getYuKou(),
				instance.getRealBeautyUrl()
		};
	}

	public static String getPageListSql(String name, int skip, int limit, String userId) {
		String conditions = "";
		if (null != name) {
			conditions += " where jdmc like '%" + name + "%'";
		}
		if (null == userId) {
			return GET_JINGDIAN_LIST + conditions + " limit " + skip + "," + limit;
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
			+ "5 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '5' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM jingdian a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		sql += "left join yukou f on f.id = a.yk ";
		return sql + conditions + " limit " + skip + "," + limit;
	}

	public static String getCountSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += " where jdmc like '%" + name + "%'";
		}
		return GET_JINGDIAN_COUNT + conditions;
	}

	public static String getUpdateSql(Topic instance) {
		String sql = "update jingdian set jdmc = '" + instance.getName() + "'";
		sql += ", wzms = '" + instance.getLocationDescription() + "'";
		sql += ", jdjj = '" + instance.getIntroduction() + "'";
		sql += ", jdrwls = '" + instance.getHistory() + "'";
		sql += ", jdzrfm = '" + instance.getNaturalFeatures() + "'";
		sql += ", jdqtsm = '" + instance.getOtherComments() + "'";
		sql += ", x = '" + instance.getxLat() + "'";
		sql += ", y = '" + instance.getyLng() + "'";
		sql += ", qx = '" + instance.getCounty() + "'";
		sql += ", xz = '" + instance.getTown() + "'";
		sql += ", yk = '" + instance.getYuKou() + "'";
		sql += ", sjlj = '" + instance.getRealBeautyUrl() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}
}
