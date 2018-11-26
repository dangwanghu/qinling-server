package com.tfssoft.qinling.base.domain;

public class TopicSql {
	public static final String GET_TOPIC_LIST = "select * from SEARCH_VIEW where "
			+ "name like ";
	
	public static String getTopicListSql(String name) {
		return GET_TOPIC_LIST + "'%" + name + "%'";
	}
}
