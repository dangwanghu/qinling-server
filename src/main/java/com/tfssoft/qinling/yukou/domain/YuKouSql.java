package com.tfssoft.qinling.yukou.domain;

import com.tfssoft.qinling.base.domain.Topic;

public class YuKouSql {
	public static final String GET_YUKOU_LIST = 
			"SElECT a.id, "
			+ "a.ykmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.ykjj AS introduction, "
			+ "a.ykrwls AS history, "
			+ "a.ykzrfm AS naturalFeatures, "
			+ "a.ykqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town, "
			+ "a.sjlj AS realBeautyUrl "
			+ "FROM yukou a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz ";
	
	public static String getYuKouListSql(Integer xiangzhen, String userId) {
		String conditions = "";
		if (null != xiangzhen) {
			conditions += "where xz = " + xiangzhen;
		}
		
		if (null == userId) {
			return GET_YUKOU_LIST + conditions;
		}
		String sql = "SElECT a.id, "
			+ "a.ykmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.ykjj AS introduction, "
			+ "a.ykrwls AS history, "
			+ "a.ykzrfm AS naturalFeatures, "
			+ "a.ykqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town, "
			+ "a.sjlj AS realBeautyUrl, "
			+ "1 AS type, "
		
			+ "(select rel_id from user_action where rel_id = a.id "
			+ "and rel_type = '1' and user_id = '" + userId + "' "
			+ "and action_type = 'SC') AS isCollected ";
			
		sql += "FROM yukou a ";
		sql += "left join dict_qvxian d on d.id = a.qx ";
		sql += "left join dict_xiangzhen e on e.id = a.xz ";
		
		return sql + conditions;
	}
	
	public static final String INSERT_YUKOU = "INSERT INTO yukou "
			+ "(ykmc, wzms, ykjj, ykrwls, ykzrfm, ykqtsm, x, y, qx, xz, sjlj) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(Topic instance) {
		return new Object[] {
				instance.getName(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getHistory(),
				instance.getNaturalFeatures(),
				instance.getOtherComments(),
				instance.getxLat(),
				instance.getyLng(),
				instance.getCounty(),
				instance.getTown(),
				instance.getRealBeautyUrl()
		};
	}

}
