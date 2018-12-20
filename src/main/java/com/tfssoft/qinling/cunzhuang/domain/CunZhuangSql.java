package com.tfssoft.qinling.cunzhuang.domain;

import com.tfssoft.qinling.base.domain.Topic;

public class CunZhuangSql {
	public static final String GET_CUNZHUANG_LIST = "SElECT a.id, " + "a.czmc AS name, " + "a.wzms AS locationDescription, "
			+ "a.czjj AS introduction, " + "a.czrwls AS history, " + "a.czqtsm AS otherComments, " + "a.x AS xLat, "
			+ "a.y AS yLng, " + "d.qxmc AS county, " + "e.xzmc AS town, " + "f.ykmc AS yuKou " 
			+ "FROM cunzhuang a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz "
			+ "left join yukou f on f.id = a.yk ";
	
	public static final String GET_CUNZHUANG_COUNT = "SElECT count(id) FROM cunzhuang a ";

	public static final String INSERT_CUNZHUANG = "INSERT INTO cunzhuang "
			+ "(czmc, wzms, czjj, czrwls, czqtsm, x, y, qx, xz, yk) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE_CUNZHUANG = "DELETE FROM cunzhuang "
			+ "where id = ?";

	public static Object[] getInsertObject(Topic instance) {
		return new Object[] {
				instance.getName(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getHistory(),
				instance.getOtherComments(),
				instance.getxLat(),
				instance.getyLng(),
				instance.getCounty(),
				instance.getTown(),
				instance.getYuKou()
		};
	}

	public static String getPageListSql(String name, int skip, int limit) {
		String conditions = "";
		if (null != name) {
			conditions += "where czmc like '%" + name + "%'";
		}
		return GET_CUNZHUANG_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where czmc like '%" + name + "%'";
		}
		return GET_CUNZHUANG_LIST + conditions;
	}

	public static String getCountSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where czmc like '%" + name + "%'";
		}
		return GET_CUNZHUANG_COUNT + conditions;
	}

	public static String getUpdateCunZhuangSql(Topic instance) {
		String sql = "update cunzhuang set czmc = '" + instance.getName() + "'";
		sql += ", wzms = '" + instance.getLocationDescription() + "'";
		sql += ", czjj = '" + instance.getIntroduction() + "'";
		sql += ", czrwls = '" + instance.getHistory() + "'";
		sql += ", czqtsm = '" + instance.getOtherComments() + "'";
		sql += ", x = '" + instance.getxLat() + "'";
		sql += ", y = '" + instance.getyLng() + "'";
		sql += ", qx = '" + instance.getCounty() + "'";
		sql += ", xz = '" + instance.getTown() + "'";
		sql += ", yk = '" + instance.getYuKou() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
