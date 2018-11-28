package com.tfssoft.qinling.fagui.domain;

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

}
