package com.tfssoft.qinling.guiji.domain;

import java.util.Date;

public class TrackSql {
	
	public static final String GET_TRACK_LIST = "SElECT id, user_id AS userId, title, description, attachments, "
			+ "start_date AS startDate, end_date AS endDate from user_track ";

	public static final String INSERT_TRACK = "INSERT INTO user_track " 
			+ "(title, description, start_date, end_date, create_time, user_id, attachments) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE_TRACK = "DELETE from user_track ";
	
	public static String getDeleteTrackSql(String ids) {	
		return DELETE_TRACK + " where id IN (" + ids + ")";
	}
	
	public static Object[] getInsertObject(TrackVO track) {
		return new Object[] { 
			track.getTitle(), 
			track.getDescription(), 
			track.getStartDate(), 
			track.getEndDate(),
			new Date(),
			track.getUserId(),
			track.getAttachments()
		};
	}

	public static String getListSql(String userId) {
		
		String conditions = " where user_id = '" + userId + "'";
		conditions += " order by create_time desc";
		
		return GET_TRACK_LIST + conditions;
	}

	public static String getByIdSql(int id) {
		return GET_TRACK_LIST + " where id = " + id;
	}

}
