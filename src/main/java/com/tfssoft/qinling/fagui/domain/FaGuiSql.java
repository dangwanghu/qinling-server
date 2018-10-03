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
			+ "FROM fagui order by publishTime desc";

}
