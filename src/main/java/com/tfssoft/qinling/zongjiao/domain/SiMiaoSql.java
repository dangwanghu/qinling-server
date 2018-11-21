package com.tfssoft.qinling.zongjiao.domain;

public class SiMiaoSql {
	public static final String GET_SIMIAO_LIST = 
			"SElECT a.id, "
			+ "a.zjmc AS name, "
			+ "a.wzms AS locationDescription, "
			+ "a.zjjj AS introduction, "
			+ "a.zjrwls AS history, "
			+ "a.zjzrfm AS naturalFeatures, "
			+ "a.zjqtsm AS otherComments, "
			+ "a.x AS xLat, "
			+ "a.y AS yLng, "
			+ "d.qxmc AS county, "
			+ "e.xzmc AS town, "
			+ "f.ykmc AS yuKou "
			+ "FROM zongjiao a "
			+ "left join dict_qvxian d on d.id = a.qx " 
			+ "left join dict_xiangzhen e on e.id = a.xz "
			+ "left join yukou f on f.id = a.yk ";

}
