package com.tfssoft.qinling.base.domain;

public class ResourceSql {
	public static final String GET_RESOURCE_LIST = "select * from SEARCH_VIEW where "
			+ "name like ";
	

	public static String getListSql(Integer parentId) {
		String sql = "";
		sql += "select a.id, a.name, a.type, a.code, a.level, a.parent_id AS parentId ";
		sql += "from resource a ";
		
		if (null != parentId) {
			sql += "where parent_id = '" + parentId.intValue() + "'"; 
		} else {
			sql += "where parent_id is null"; 
		}
		
		sql += " order by id asc";
		
		return sql;
	}

}
