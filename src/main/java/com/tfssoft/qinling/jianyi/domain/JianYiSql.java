package com.tfssoft.qinling.jianyi.domain;

import java.util.Date;

public class JianYiSql {
	public static final String INSRT_JIANYI = "INSERT INTO jianyi "
			+ "(content, submitter, phone, create_time, user_id) " + "values "
			+ "(?, ?, ?, ?, ?)";
	
	public static final String GET_JIANYI_LIST = 
			"SElECT id, update_time AS updateTime, "
			+ "content, "
			+ "submitter, "
			+ "phone, "
			+ "create_time AS createTime, comments, "
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
				new Date(),
				Integer.parseInt(instance.getUserId())
		};
	}
	
	public static String getPageListSql(String content, int skip, int limit, String status, String statusIn, String userId) {
		String conditions = " where status IN (" + statusIn + ") ";
		if (null != content) {
			conditions += " and content like '%" + content + "%'";
		}
		if (null != status) {
			conditions += " and status = '" + status + "'";
		}
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		conditions += " order by createTime desc";
		return GET_JIANYI_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String content, String status, String statusIn, String userId) {
		String conditions = " where status IN (" + statusIn + ") ";
		if (null != content) {
			conditions += "and content like '%" + content + "%'";
		}
		if (null != status) {
			conditions += " and status = '" + status + "'";
		}
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		conditions += " order by createTime desc";
		return GET_JIANYI_LIST + conditions;
	}

	public static String getCountSql(String content, String status, String statusIn, String userId) {
		String conditions = " where status IN (" + statusIn + ") ";
		if (null != content) {
			conditions += "and content like '%" + content + "%'";
		}
		if (null != status) {
			conditions += " and status = '" + status + "'";
		}
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		return GET_JIANYI_COUNT + conditions;
	}

	public static String getUpdateJianYiSql(Suggest instance) {
		String sql = "update jianyi set update_time = now(), status = '" + instance.getStatus() + "'";

		if (null != instance.getComments()) {
			sql += ", comments = '" + instance.getComments() + "'";
		}
		sql += " where id = " + instance.getId().intValue();
		return sql;
	}
	
	public static String getBatchUpdateJianYiSql(String ids, String status) {
		String sql = "update jianyi set update_time = now(), status = '" + status + "'";

		sql += " where id IN (" + ids + ")";
		return sql;
	}

}
