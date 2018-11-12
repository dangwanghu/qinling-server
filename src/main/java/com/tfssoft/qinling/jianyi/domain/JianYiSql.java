package com.tfssoft.qinling.jianyi.domain;

import java.util.Date;

public class JianYiSql {
	public static final String INSRT_JIANYI = "INSERT INTO jianyi "
			+ "(content, submitter, phone, create_time) " + "values "
			+ "(?, ?, ?, ?)";

	public static Object[] getInsertObject(Suggest instance) {
		return new Object[] {
				instance.getContent(),
				instance.getSubmitter(),
				instance.getPhone(),
				new Date()
		};
	}

}
