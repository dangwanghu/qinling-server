package com.tfssoft.qinling.cunzhuang.domain;

import com.tfssoft.qinling.base.domain.Topic;

public class CunZhuangSql {
	public static final String GET_CUNZHUANG_LIST = "SElECT id, " + "czmc AS name, " + "wzms AS locationDescription, "
			+ "czjj AS introduction, " + "czrwls AS history, " + "czqtsm AS otherComments, " + "x AS xLat, "
			+ "y AS yLng, " + "qx AS county, " + "xz AS town, " + "yk AS yuKou " + "FROM cunzhuang";

	public static final String INSRT_CUNZHUANG = "INSERT INTO cunzhuang "
			+ "(czmc, wzms, czjj, czrwls, czqtsm, x, y, qx, xz, yk) " + "values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(Topic instance) {
		return new Object[] {
				instance.getName(),
				instance.getLocationDescription(),
				instance.getIntroduction(),
				instance.getHistory(),
				instance.getOtherComments(),
				instance.getxLat(),
				instance.getyLng(),
				instance.getCounty(),
				instance.getTown(),
				instance.getYuKou()
		};
	}

}
