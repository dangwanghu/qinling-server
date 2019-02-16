package com.tfssoft.qinling.user.domain;

import java.util.Date;

import com.tfssoft.qinling.util.EncryptionByMD5;

public class ManagerSql {
	public static final String GET_MANAGER_LIST = 
			"SElECT a.id, a.email, a.real_name AS realName, a.role, a.sex, a.phone, a.status, " 
			+ "d.name AS roleName, d.scope AS roleScope, " + "a.create_time AS createTime, " + "a.update_time AS updateTime " 
			+ "FROM manager a "
			+ "left join role d on d.id = a.role ";
	
	public static final String GET_MANAGER_COUNT = "SElECT count(id) FROM manager a ";

	public static final String INSERT_MANAGER = "INSERT INTO manager "
			+ "(role, email, password, phone, sex, real_name, status, create_time, update_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE_MANAGER = "DELETE FROM manager "
			+ "where id = ?";

	public static Object[] getInsertObject(ManagerPostVO instance) {
		return new Object[] {
				instance.getRole(),
				instance.getEmail(),
				new String(EncryptionByMD5.getMD5(instance.getPassword().getBytes())),
				instance.getPhone(),
				instance.getSex(),
				instance.getRealName(),
				1,
				new Date(),
				new Date()
		};
	}

	public static String getPageListSql(String name, int skip, int limit) {
		String conditions = "";
		if (null != name) {
			conditions += "where real_name like '%" + name + "%'";
		}
		return GET_MANAGER_LIST + conditions + " limit " + skip + "," + limit;
	}

	public static String getListSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where real_name like '%" + name + "%'";
		}
		return GET_MANAGER_LIST + conditions;
	}

	public static String getCountSql(String name) {
		String conditions = "";
		if (null != name) {
			conditions += "where real_name like '%" + name + "%'";
		}
		return GET_MANAGER_COUNT + conditions;
	}

	public static String getUpdateManagerSql(ManagerPostVO instance) {
		String sql = "update manager set role = '" + instance.getRole() + "'";
		sql += ", real_name = '" + instance.getRealName() + "'";
		sql += ", sex = '" + instance.getSex() + "'";
		sql += ", phone = '" + instance.getPhone() + "'";
		sql += ", status = '" + instance.getStatus() + "'";
		sql += ", update_time = now()";
		
		sql += " where id = " + instance.getId().intValue();
		return sql;
	}
	
	public static String getManagerLoginSql(String email, String password) {
		return GET_MANAGER_LIST + " where email = '" + email + "'" + " and password = MD5('" + password + "')";
	}


}
