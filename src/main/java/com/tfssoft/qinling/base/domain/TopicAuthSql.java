package com.tfssoft.qinling.base.domain;

import java.util.Date;

public class TopicAuthSql {
	public static final String GET_TOPIC_AUTH_LIST = "select id,"
			+ "topic_type AS topicType, "
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
			+ "(topic_type, location_desc, introduction, reason, x, y, attachments, create_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?)";

	
	public static final String DELETE_TOPIC_AUTH = "DELETE from topic_auth ";

	public static String getDeleteTopicAuthSql(String ids) {	
		return DELETE_TOPIC_AUTH + "where id IN (" + ids + ")";
	}
	
	public static Object[] getInsertObject(TopicAuth instance) {
		return new Object[] {
				instance.getTopicType(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getReason(),
				instance.getxLat(),
				instance.getyLng(),
				instance.getAttachments(),
				new Date()
		};
	}
	
	public static String getListSql(String name, String status) {
		String conditions = "where status IN (" + status + ") ";
		if (null != name) {
			conditions += "and location_desc like '%" + name + "%'";
		}
		return GET_TOPIC_AUTH_LIST + conditions;
	}

	public static String getPageListSql(String name, int skip, int limit, String status) {
		String conditions = "where status IN (" + status + ") ";
		if (null != name) {
			conditions += "and location_desc like '%" + name + "%'";
		}
		return GET_TOPIC_AUTH_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getCountSql(String name, String status) {
		String conditions = "where status IN (" + status + ") ";
		if (null != name) {
			conditions += "and location_desc like '%" + name + "%'";
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

}
