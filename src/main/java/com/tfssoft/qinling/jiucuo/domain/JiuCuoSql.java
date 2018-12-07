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
			+ "(case type when 'CZ' then '村庄' when 'JD' then '景点'"
			+ " when 'SF' then '山峰' when 'YK' then '峪口' when 'ZJ' then '宗教' else '其它' end) type, "
			+ "rel_id AS relId,"
			+ "content, "
			+ "submitter, "
			+ "phone, "
			+ "create_time AS createTime, "
			+ "(case status when 0 then '未处理' when 1 then '已处理' end) status"
			+ " FROM jiucuo ";
	
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

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
