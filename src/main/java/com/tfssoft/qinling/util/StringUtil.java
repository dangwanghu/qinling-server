package com.tfssoft.qinling.util;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if (null != str && !"".equals(str.trim()))
			return false;
		return true;
	}
}
