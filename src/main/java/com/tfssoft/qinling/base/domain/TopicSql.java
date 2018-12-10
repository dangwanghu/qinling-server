package com.tfssoft.qinling.base.domain;

import java.util.Date;

public class TopicSql {
	public static final String GET_TOPIC_LIST = "select * from SEARCH_VIEW where "
			+ "name like ";
	
	public static String getTopicListSql(String name, String userId) {
		if (null == userId) {
			return GET_TOPIC_LIST + "'%" + name + "%'";
		}
		String sql = "";
		sql += "select a.*,";
		sql += " (select rel_id from user_action where rel_id = a.id and rel_type = a.type and user_id = '" + userId + "' and action_type = 'SC') AS isCollected ";
		sql += "from SEARCH_VIEW a ";
		sql += "where name like '%" + name + "%'"; 
		
		return sql;
	}
	
	public static final String INSRT_TOPIC_AUTH = "INSERT INTO topic_auth "
			+ "(topic_type, location_desc, introduction, reason, x, y, attachments, create_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static Object[] getInsertAuthObject(TopicAuth instance) {
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

	public static String getTopicDetailSql(String id, String type, String userId) {
		String conditons = " where a.id = '" + id + "' and type = '" + type + "'";
		if (null == userId) {
			return "select a.* from SEARCH_VIEW a" + conditons;
		}
		
		String sql = "";
		sql += "select a.*,";
		sql += " (select rel_id from user_action where rel_id = a.id and rel_type = a.type and user_id = '" + userId + "' and action_type = 'SC') AS isCollected ";
		sql += "from SEARCH_VIEW a";
		sql += conditons; 
		
		return sql;
	}
}
