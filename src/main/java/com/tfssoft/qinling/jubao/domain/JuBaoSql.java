package com.tfssoft.qinling.jubao.domain;

import java.util.Date;

public class JuBaoSql {
	public static final String INSRT_JUBAO = "INSERT INTO jubao "
			+ "(attachments, content, submitter, phone, create_time) " + "values "
			+ "(?, ?, ?, ?, ?)";

	public static Object[] getInsertObject(Report instance) {
		return new Object[] {
				instance.getAttachments(),
				instance.getContent(),
				instance.getSubmitter(),
				instance.getPhone(),
				new Date()
		};
	}

}
