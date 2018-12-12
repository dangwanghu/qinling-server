package com.tfssoft.qinling.jiucuo.domain;

import java.util.Date;

public class JiuCuoSql {
	public static final String INSRT_JIUCUO = "INSERT INTO jiucuo "
			+ "(type, rel_id, content, submitter, phone, create_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(Correction instance) {
		return new Object[] {
				instance.getType(),
				instance.getRelId(),
				instance.getContent(),
				instance.getSubmitter(),
				instance.getPhone(),
				new Date()
		};
	}
	
	public static final String GET_JIUCUO_LIST = 
			"SElECT id, update_time AS updateTime, "
			+ "(case type when 6 then '村庄' when 5 then '景点'"
			+ " when 3 then '山峰' when 1 then '峪口' when 4 then '宗教' else '其它' end) type, "
			+ "rel_id AS relId,"
			+ "content, "
			+ "submitter, "
			+ "phone, "
			+ "(select name from search_view where type = a.type and id = a.rel_id) AS subjectName, "
			+ "create_time AS createTime, comments, "
			+ "(case status when 0 then '未处理' when 1 then '已处理' end) status"
			+ " FROM jiucuo a";
	
	public static final String GET_JIUCUO_COUNT = "SElECT count(id) FROM jiucuo ";
	
	public static final String DELETE_JIUCUO = "DELETE FROM jiucuo "
			+ "where id = ?";
	
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
		return GET_JIUCUO_LIST + conditions + " limit " + skip + "," + limit;
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
		return GET_JIUCUO_LIST + conditions;
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
		return GET_JIUCUO_COUNT + conditions;
	}

	public static String getUpdateJiuCuoSql(Correction instance) {
		String sql = "update jiucuo set update_time = now(), status = '" + instance.getStatus() + "'";

		if (null != instance.getComments()) {
			sql += ", comments = '" + instance.getComments() + "'";
		}
		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
