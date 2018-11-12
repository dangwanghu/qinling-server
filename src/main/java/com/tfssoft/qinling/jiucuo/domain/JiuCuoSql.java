package com.tfssoft.qinling.jiucuo.domain;

import java.util.Date;

public class JiuCuoSql {
	public static final String INSRT_JIUCUO = "INSERT INTO jiucuo "
			+ "(type, rel_id, content, submitter, phone, create_time) " + "values "
			+ "(?, ?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(Correction instance) {
		return new Object[] {
				instance.getType(),
				instance.getRelId(),
				instance.getContent(),
				instance.getSubmitter(),
				instance.getPhone(),
				new Date()
		};
	}

}
