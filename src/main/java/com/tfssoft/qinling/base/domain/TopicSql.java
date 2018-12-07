package com.tfssoft.qinling.base.domain;

import java.util.Date;

public class TopicSql {
	public static final String GET_TOPIC_LIST = "select * from SEARCH_VIEW where "
			+ "name like ";
	
	public static String getTopicListSql(String name) {
		return GET_TOPIC_LIST + "'%" + name + "%'";
	}
	
	public static final String INSRT_TOPIC_AUTH = "INSERT INTO topic_auth "
			+ "(topic_type, location_desc, introduction, reason, x, y, create_time) " + "values "
			+ "(?, ?, ?, ?)";
	
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
