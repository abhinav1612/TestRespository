package com.goeuro.test.util;

public class GoEuroStringUtils {

	public static boolean isEmptyorNull(String input) {

		boolean flag = true;
		if (input != null && !input.isEmpty()) {
			flag = false;
		}
		return flag;
	}

	
	
}
