package com.tfssoft.qinling.jianyi.domain;

import java.util.Date;

public class JianYiSql {
	public static final String INSRT_JIANYI = "INSERT INTO jianyi "
			+ "(content, submitter, phone, create_time) " + "values "
			+ "(?, ?, ?, ?)";
	
	public static final String GET_JIANYI_LIST = 
			"SElECT id, update_time AS updateTime, "
			+ "content, "
			+ "submitter, "
			+ "phone, "
			+ "create_time AS createTime, "
			+ "(case status when 0 then '未处理' when 1 then '已处理' end) status"
			+ " FROM jianyi ";
	
	public static final String GET_JIANYI_COUNT = "SElECT count(id) FROM jianyi ";
	
	public static final String DELETE_JIANYI = "DELETE FROM jianyi "
			+ "where id = ?";
	
	public static Object[] getInsertObject(Suggest instance) {
		return new Object[] {
				instance.getContent(),
				instance.getSubmitter(),
				instance.getPhone(),
				new Date()
		};
	}
	
	public static String getPageListSql(String content, int skip, int limit) {
		String conditions = "";
		if (null != content) {
			conditions += "where content like '%" + content + "%'";
		}
		conditions += " order by createTime desc";
		return GET_JIANYI_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String content) {
		String conditions = "";
		if (null != content) {
			conditions += "where content like '%" + content + "%'";
		}
		conditions += " order by createTime desc";
		return GET_JIANYI_LIST + conditions;
	}

	public static String getCountSql(String content) {
		String conditions = "";
		if (null != content) {
			conditions += "where content like '%" + content + "%'";
		}
		return GET_JIANYI_COUNT + conditions;
	}

	public static String getUpdateJianYiSql(Suggest instance) {
		String sql = "update jianyi set update_time = now(), status = '" + instance.getStatus() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
