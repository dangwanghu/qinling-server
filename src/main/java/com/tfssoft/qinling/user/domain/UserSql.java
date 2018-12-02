package com.tfssoft.qinling.user.domain;

import java.util.Date;

public class UserSql {

	public static final String GET_USER_BY_CONDITIONS = 
			"SElECT id, " 
			+ "nick_name AS nickName, " 
			+ "avatar AS avatar, " 
			+ "real_name AS realName, " 
			+ "sex AS sex, " 
			+ "phone AS phone, " 
			+ "province AS province, " 
			+ "city AS city, " 
			+ "street AS street, " 
			+ "token AS token "
			+ "FROM user where status = 1 and ";
	
	public static final String INSRT_USER = "INSERT INTO user "
			+ "(open_id, open_type, user_platform, nick_name, phone, avatar, sex, status, create_time) "
			+ "values " + "(?, ?, ?, ?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(User instance) {
		return new Object[] {
				instance.getOpenId(),
				instance.getOpenType(),
				instance.getUserPlatform(),
				instance.getNickName(),
				instance.getPhone(),
				instance.getAvatar(),
				instance.getSex(),
				1,
				new Date()
		};
	}
	
	public static String getUserLoginSql(String phone, String password) {
		return GET_USER_BY_CONDITIONS 
				+ "phone = '" + phone + "'"
				+ " and password = MD5('" + password + "')";
	}
	
	public static String getUserByPhoneSql(String phone) {
		return GET_USER_BY_CONDITIONS 
				+ "phone = '" + phone + "'";
	}

	public static String getUserThirdPartyLoginSql(String openId, String openType) {
		return GET_USER_BY_CONDITIONS 
				+ "open_id = '" + openId + "'"
				+ " and open_type = '" + openType + "'";
	}
	
	public static String getUpdateUserSql(User user) {
		String sql = "update user set update_time = now()";
		if (null != user.getNickName()) {
			sql += ", nick_name = '" + user.getNickName() + "'";
		}
		if (null != user.getAvatar()) {
			sql += ", avatar = '" + user.getAvatar() + "'";
		}
		if (null != user.getSex()) {
			sql += ", sex = '" + user.getSex() + "'";
		}
		if (null != user.getPhone()) {
			sql += ", phone = '" + user.getPhone() + "'";
		}
		if (null != user.getPassword()) {
			sql += ", password = MD5('" + user.getPassword() + "')";
		}
		sql += " where id = " + user.getId().intValue();
		return sql;
	}
}
