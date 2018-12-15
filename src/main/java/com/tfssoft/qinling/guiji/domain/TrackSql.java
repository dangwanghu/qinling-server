package com.tfssoft.qinling.guiji.domain;

import java.util.Date;

public class TrackSql {
	
	public static final String GET_TRACK_LIST = "SElECT id, title, points AS pointIds, description, "
			+ "start_date AS startDate, end_date AS endDate from user_track ";

	public static final String INSERT_TRACK = "INSERT INTO user_track " 
			+ "(title, points, description, start_date, end_date, create_time, user_id) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE_TRACK = "DELETE from user_track ";
	
	public static String getDeleteTrackSql(String ids) {	
		return DELETE_TRACK + " where id IN (" + ids + ")";
	}
	
	public static Object[] getInsertObject(TrackVO track) {
		return new Object[] { 
				track.getTitle(), 
				track.getPoints(),
				track.getDescription(), 
				track.getStartDate(), 
				track.getEndDate(),
				new Date(),
				track.getUserId()
				};
	}

	public static String getListSql(String userId, String startDate, String endDate) {
		
		String conditions = " where user_id = '" + userId + "'";
		if (null != startDate) {
			conditions += " and start_date >= '" + startDate + "'";
		}
		if (null != endDate) {
			conditions += " and end_date <= '" + endDate + "'";
		}
		conditions += " order by create_time desc";
		
		return GET_TRACK_LIST + conditions;
	}

	public static String getByIdSql(int id) {
		return GET_TRACK_LIST + " where id = " + id;
	}

}
