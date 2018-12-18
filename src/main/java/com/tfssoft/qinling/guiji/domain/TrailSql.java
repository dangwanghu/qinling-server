package com.tfssoft.qinling.guiji.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrailSql {
	public static final String GET_TRAIL_LIST = "SElECT id, x AS xLat, y AS yLng, z AS zHeg, create_time AS time from user_trail ";

	public static final String INSERT_TRAIL = "INSERT INTO user_trail " + "(user_id, x, y, z, create_time) " + "values "
			+ "(?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(TrailVO trail) {
		return new Object[] { 
				Integer.parseInt(trail.getUserId()), 
				trail.getxLat(), 
				trail.getyLng(), 
				trail.getzHeg(),
				new Date() };
	}
	
	public static List<Object[]> getInsertObjectBatch(String userId, List<Trail> trails) {
		List<Object[]> params = new ArrayList<Object[]>();
		for (Trail trail : trails) {
			params.add(new Object[] { 
				Integer.parseInt(userId), 
				trail.getxLat(), 
				trail.getyLng(), 
				trail.getzHeg(),
				trail.getTime()
			});
		}
		return params;
	}

	public static String getListCurrentWeekSql(String userId) {
		String conditions = " where date_sub(curdate(), interval 7 day) < create_time ";
		if (null != userId) {
			conditions += " and user_id = '" + userId + "'";
		}
		conditions += " order by create_time desc";
		return GET_TRAIL_LIST + conditions;
	}
	
	public static String getListSql(String userId, Date startDate, Date endDate) {
		String conditions = " where user_id = '" + userId + "'";
		conditions += " and unix_timestamp(create_time) * 1000 BETWEEN " + startDate.getTime() + " AND " + endDate.getTime() + "";
		conditions += " order by create_time desc";
		return GET_TRAIL_LIST + conditions;
	}

	public static String getListByIdsSql(String ids) {
		return GET_TRAIL_LIST + " where id in (" + ids + ")";
	}

}
