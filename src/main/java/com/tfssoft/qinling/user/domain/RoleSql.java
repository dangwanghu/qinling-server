package com.tfssoft.qinling.user.domain;

import java.util.Date;

public class RoleSql {
	public static final String GET_ROLE_LIST = 
			"SElECT a.id, a.scope, a.name, a.status, a.create_time AS createTime, a.update_time AS updateTime " 
			+ "FROM role a ";
	
	public static final String GET_ROLE_COUNT = "SElECT count(id) FROM role a ";

	public static final String INSERT_ROLE = "INSERT INTO role "
			+ "(name, status, scope, create_time, update_time) " + "values "
			+ "(?, ?, ?, ?, ?)";
	
	public static final String DELETE_ROLE = "DELETE FROM role "
			+ "where id = ?";

	public static Object[] getInsertObject(RolePostVO instance) {
		return new Object[] {
				instance.getName(),
				1,
				instance.getScope(),
				new Date(),
				new Date()
		};
	}

	public static String getPageListSql(String name, int skip, int limit) {
		String conditions = "";
		if (null != name) {
			conditions += "where name like '%" + name + "%'";
		}
		return GET_ROLE_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where name like '%" + name + "%'";
		}
		return GET_ROLE_LIST + conditions;
	}

	public static String getCountSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where name like '%" + name + "%'";
		}
		return GET_ROLE_COUNT + conditions;
	}

	public static String getUpdateRoleSql(RolePostVO instance) {
		String sql = "update role set name = '" + instance.getName() + "'";
		sql += ", status = '" + instance.getStatus() + "'";
		sql += ", scope = '" + instance.getScope() + "'";
		sql += ", update_time = now()";
		
		sql += " where id = " + instance.getId().intValue();
		return sql;
	}

}
