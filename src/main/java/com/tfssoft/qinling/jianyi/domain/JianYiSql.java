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
	
	public static String getPageListSql(String content, int skip, int limit, String status) {
		String conditions = "";
		if (null != content || null != status) {
			conditions += "where ";
		}
		if (null != content) {
			conditions += "content like '%" + content + "%'";
		}
		if (null != content && null != status) {
			conditions += " and ";
		}
		if (null != status) {
			conditions += "status = '" + status + "'";
		}
		conditions += " order by createTime desc";
		return GET_JIANYI_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String content, String status) {
		String conditions = "";
		if (null != content || null != status) {
			conditions += "where ";
		}
		if (null != content) {
			conditions += "content like '%" + content + "%'";
		}
		if (null != content && null != status) {
			conditions += " and ";
		}
		if (null != status) {
			conditions += "status = '" + status + "'";
		}
		conditions += " order by createTime desc";
		return GET_JIANYI_LIST + conditions;
	}

	public static String getCountSql(String content, String status) {
		String conditions = "";
		if (null != content || null != status) {
			conditions += "where ";
		}
		if (null != content) {
			conditions += "content like '%" + content + "%'";
		}
		if (null != content && null != status) {
			conditions += " and ";
		}
		if (null != status) {
			conditions += "status = '" + status + "'";
		}
		return GET_JIANYI_COUNT + conditions;
	}

	public static String getUpdateJianYiSql(Suggest instance) {
		String sql = "update jianyi set update_time = now(), status = '" + instance.getStatus() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
