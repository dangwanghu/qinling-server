package com.tfssoft.qinling.base.domain;

import java.util.Date;

public class TopicAuthSql {
	public static final String GET_TOPIC_AUTH_LIST = "select id,"
			+ "topic_type AS type, "
			+ "location_desc AS locationDescription, "
			+ "introduction, "
			+ "reason, "
			+ "attachments, "
			+ "x AS xLat, "
			+ "y AS yLng, "
			+ "status, "
			+ "create_time AS createTime, "
			+ "update_time AS updateTime from topic_auth ";
	
	public static final String GET_TOPIC_AUTH_COUNT = "select count(id) from topic_auth ";
	
	public static final String INSRT_TOPIC_AUTH = "INSERT INTO topic_auth "
			+ "(topic_type, location_desc, introduction, reason, x, y, attachments, create_time, user_id) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	
	public static final String DELETE_TOPIC_AUTH = "DELETE from topic_auth ";

	public static String getDeleteTopicAuthSql(String ids) {	
		return DELETE_TOPIC_AUTH + "where id IN (" + ids + ")";
	}
	
	public static Object[] getInsertObject(TopicAuth instance) {
		return new Object[] {
				instance.getType(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getReason(),
				instance.getxLat(),
				instance.getyLng(),
				instance.getAttachments(),
				new Date(),
				Integer.parseInt(instance.getUserId())
		};
	}
	
	public static String getListSql(String name, String statusIn, String userId, String status) {
		String conditions = "where status IN (" + statusIn + ") ";
		if (null != name) {
			conditions += " and location_desc like '%" + name + "%'";
		}
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		if (null != status) {
			conditions += " and status = '" + status + "'";
		}
		return GET_TOPIC_AUTH_LIST + conditions;
	}

	public static String getPageListSql(String name, int skip, int limit, String statusIn, String userId, String status) {
		String conditions = "where status IN (" + statusIn + ") ";
		if (null != name) {
			conditions += "and location_desc like '%" + name + "%' ";
		}
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		if (null != status) {
			conditions += " and status = '" + status + "'";
		}
		conditions += " order by create_time desc";
		return GET_TOPIC_AUTH_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getCountSql(String name, String statusIn, String userId, String status) {
		String conditions = "where status IN (" + statusIn + ") ";
		if (null != name) {
			conditions += "and location_desc like '%" + name + "%'";
		}
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		if (null != status) {
			conditions += " and status = '" + status + "'";
		}
		return GET_TOPIC_AUTH_COUNT + conditions;
	}


	public static String getUpdateTopicAuthSql(TopicAuth instance) {
		String sql = "update topic_auth set update_time = now(), status = '" + instance.getStatus() + "'";

		if (null != instance.getComments()) {
			sql += ", comments = '" + instance.getComments() + "'";
		}
		sql += " where id = " + instance.getId().intValue();
		return sql;
	}
	
	public static String getBatchUpdateTopicAuthSql(String ids, String status) {
		String sql = "update topic_auth set update_time = now(), status = '" + status + "'";

		sql += " where id IN (" + ids + ")";
		return sql;
	}
	
	public static String getTopicAuthByIdSql(int id) {
		return GET_TOPIC_AUTH_LIST + "where id = " + id;
	}

}
