package com.tfssoft.qinling.base.domain;

public class DictSql {
	public static final String GET_DICT_QX_LIST = "select id, qxmc AS name from dict_qvxian";
	
	public static final String GET_DICT_XZ_LIST = "select id, xzmc AS name from dict_xiangzhen ";

	public static String getXzListSql(Integer quxian) {
		String conditions = "";
		if (null != quxian) {
			conditions += "where qx = " + quxian;
		}
		return GET_DICT_XZ_LIST + conditions;
	}
}
