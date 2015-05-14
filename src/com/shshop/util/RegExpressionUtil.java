package com.shshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpressionUtil {
	public static Pattern EMAIL = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");

	public static boolean isValidEmail(String email) {
		Matcher m = EMAIL.matcher(email);
		if (m.matches())
			return true;
		
		return false;
	}
}
