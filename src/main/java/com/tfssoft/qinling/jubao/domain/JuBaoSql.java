package com.tfssoft.qinling.jubao.domain;

import java.util.Date;

import com.tfssoft.qinling.jubao.domain.Report;

public class JuBaoSql {
	public static final String INSRT_JUBAO = "INSERT INTO jubao "
			+ "(attachments, content, submitter, phone, create_time) " + "values "
			+ "(?, ?, ?, ?, ?)";
	
	public static final String GET_JUBAO_LIST = 
			"SElECT id, update_time AS updateTime, "
			+ "attachments, "
			+ "content, "
			+ "submitter, "
			+ "phone, "
			+ "create_time AS createTime, "
			+ "(case status when 0 then '未处理' when 1 then '已处理' end) status"
			+ " FROM jubao ";
	
	public static final String GET_JUBAO_COUNT = "SElECT count(id) FROM jubao ";
	
	public static final String DELETE_JUBAO = "DELETE FROM jubao "
			+ "where id = ?";

	public static Object[] getInsertObject(Report instance) {
		return new Object[] {
				instance.getAttachments(),
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
		return GET_JUBAO_LIST + conditions + " limit " + skip + "," + limit;
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
		return GET_JUBAO_LIST + conditions;
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
		return GET_JUBAO_COUNT + conditions;
	}

	public static String getUpdateJuBaoSql(Report instance) {
		String sql = "update jubao set update_time = now(), status = '" + instance.getStatus() + "'";

		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
