package com.tfssoft.qinling.fagui.domain;

import java.util.Date;

public class FaGuiSql {
	public static final String GET_FAGUI_LIST = 
			"SElECT id, "
			+ "fgmc AS name, "
			+ "fbdw AS publishUnit, "
			+ "fbsj AS publishTime, "
			+ "sssj AS implementTime, "
			+ "url AS url, "
			+ "lx AS urlType, "
			+ "qtsm AS urlTypeDescription "
			+ "FROM fagui ";
	
	public static final String GET_FAGUI_COUNT = "SElECT count(id) FROM fagui ";
	
	public static final String INSERT_FAGUI = "INSERT INTO fagui "
			+ "(fgmc, fbdw, fbsj, sssj, lx, url, qtsm) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE_FAGUI = "DELETE FROM fagui "
			+ "where id = ?";
	
	public static Object[] getInsertObject(Rule instance) {
		return new Object[] {
				instance.getName(),
				instance.getPublishUnit(),
				new Date(),
				instance.getImplementTime(),
				instance.getUrlType(),
				instance.getUrl(),
				instance.getUrlTypeDescription()
		};
	}

	public static String getPageListSql(String name, int skip, int limit) {
		String conditions = "";
		if (null != name) {
			conditions += "where fgmc like '%" + name + "%'";
		}
		conditions += " order by publishTime desc";
		return GET_FAGUI_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where fgmc like '%" + name + "%'";
		}
		conditions += " order by publishTime desc";
		return GET_FAGUI_LIST + conditions;
	}
	
	public static String getCountSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where fgmc like '%" + name + "%'";
		}
		return GET_FAGUI_COUNT + conditions;
	}
	
	public static String getUpdateFaGuiSql(Rule instance) {
		String sql = "update fagui set fgmc = '" + instance.getName() + "'";
		sql += ", fbdw = '" + instance.getPublishUnit() + "'";
		sql += ", sssj = '" + instance.getImplementTime() + "'";
		sql += ", lx = '" + instance.getUrlType() + "'";
		sql += ", url = '" + instance.getUrl() + "'";
		sql += ", qtsm = '" + instance.getUrlTypeDescription() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
