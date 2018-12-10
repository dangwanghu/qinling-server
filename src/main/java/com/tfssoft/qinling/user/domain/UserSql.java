package com.tfssoft.qinling.user.domain;

import java.util.Date;

public class UserSql {

	public static final String GET_USER_BY_CONDITIONS = "SElECT id, password, " + "open_id AS openId, "
			+ "open_type AS openType, " + "nick_name AS nickName, " + "avatar AS avatar, " + "real_name AS realName, "
			+ "sex AS sex, " + "phone AS phone, " + "province AS province, " + "city AS city, " + "street AS street, "
			+ "token AS token " + "FROM user where status = 1 and ";

	public static final String INSRT_USER = "INSERT INTO user "
			+ "(open_id, open_type, user_platform, nick_name, phone, avatar, sex, status, create_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String INSERT_USER_ACTION = "INSERT INTO user_action "
			+ "(rel_id, rel_type, user_id, action_type, create_time) " + "values " + "(?, ?, ?, ?, ?)";

	public static final String DELETE_USER_ACTION = "DELETE from user_action ";

	public static String getDeleteUserActionSql(String ids) {
		return DELETE_USER_ACTION + "where id in (" + ids + ")";
	}

	public static Object[] getUserActionInsertObject(UserActionPostVO action) {
		return new Object[] { action.getRelId(), action.getRelType(), action.getUserId(), "SC", new Date() };
	}

	public static Object[] getInsertObject(User instance) {
		return new Object[] { instance.getOpenId(), instance.getOpenType(), instance.getUserPlatform(),
				instance.getNickName(), instance.getPhone(), instance.getAvatar(), instance.getSex(), 1, new Date() };
	}

	public static String getUserLoginSql(String phone, String password) {
		return GET_USER_BY_CONDITIONS + "phone = '" + phone + "'" + " and password = MD5('" + password + "')";
	}

	public static String getUserByPhoneSql(String phone) {
		return GET_USER_BY_CONDITIONS + "phone = '" + phone + "'";
	}

	public static String getUserByIdSql(int id) {
		return GET_USER_BY_CONDITIONS + "id = '" + id + "'";
	}

	public static String getUserThirdPartyLoginSql(String openId, String openType) {
		return GET_USER_BY_CONDITIONS + "open_id like '%" + openId + "%'" + " and open_type like '%" + openType + "%'";
	}

	public static String getUpdateUserSql(User user) {
		String sql = "update user set update_time = now()";
		if (null != user.getOpenId()) {
			sql += ", open_id = '" + user.getOpenId() + "'";
		}
		if (null != user.getOpenType()) {
			sql += ", open_type = '" + user.getOpenType() + "'";
		}
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

	public static String getUserCollectListSql(String userId, String relId, String relType) {
		String sql = "select b.id, b.relId, b.rel_type as relType, c.name AS relName, ";
		sql += "c.locationDescription AS address from ";
		sql += " (select a.id, a.rel_id AS relId, a.create_time As createTime,";
		sql += " a.rel_type from user_action a where a.user_id = '" + userId + "'";
		
		if (null != relId) {
			sql += " and a.rel_id = '" + relId + "'";
		}
		
		if (null != relType) {
			sql += " and a.rel_type = '" + relType + "'";
		}
				
		sql += ") b left join SEARCH_VIEW c on b.relId = c.id and b.rel_type = c.type";

		return sql;
	}
}
