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
		sql += "select b.*,";
		sql += " (select rel_id from user_action where rel_id = b.id and rel_type = b.typeName and user_id = '" + userId + "' and action_type = 'SC') AS isCollected ";
		sql += "from (";
		sql += "select a.*, (case type when 4 then 'ZJ' when 5 then 'JD' when 1 then 'YK' when 3 then 'SF' end) as typeName from SEARCH_VIEW a ";
		sql += "where name like '%" + name + "%') b"; 
		
		return sql;
	}
	
	public static final String INSRT_TOPIC_AUTH = "INSERT INTO topic_auth "
			+ "(topic_type, location_desc, introduction, reason, x, y, create_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?)";
	
	public static Object[] getInsertAuthObject(TopicAuth instance) {
		return new Object[] {
				instance.getTopicType(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getReason(),
				instance.getxLat(),
				instance.getyLng(),
				new Date()
		};
	}
}
