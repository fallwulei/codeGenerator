package com.suncreate.codergen.utils;

import java.io.File;

import org.apache.commons.lang.StringUtils;

public class UtilsString {

	public static String camelize(String s) {
		if (null == s) {
			return null;
		}

		String[] ss = s.split("_");
		for (int i = 0; i < ss.length; i++) {
			ss[i] = StringUtils.capitalize(ss[i].toLowerCase());
		}

		return StringUtils.join(ss);
	}

	public static String concat(String path, String name) {
		return new StringBuffer().append(path).append(File.separator).append(name).toString();
	}

	public static String toLowerCaseFirstLetter(String s) {
		if (null == s) {
			return null;
		}

		String firstLetter = String.valueOf(s.charAt(0));

		return s.replaceFirst(firstLetter, firstLetter.toLowerCase());
	}

	public static String removeQuote(String s) {
		if (null == s) {
			return null;
		}

		return s.replaceAll("(')|(\")", "");
	}
}
