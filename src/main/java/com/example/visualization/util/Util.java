package com.example.visualization.util;

public class Util {
	
	public static String processCode(String code) {
		String processedCode = code.toString()
								   .replace("\\\"", "\"")
								   .replace("\\n", "")
								   .replace("\\t", "");
		return processedCode;
	}
	
	public static boolean isValidString(String string) {
		return string != null && !string.isEmpty();
	}

}
