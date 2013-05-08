package com.oneweek.util;


public class Encoding {
	
	private static Encoding encoding;
	
	private Encoding() {
	}

	public static Encoding getInstance() {
		if (encoding == null) {
			encoding = new Encoding();
		}
		return encoding;
	}
	
	public String convertISOtoUTF8(String str) {
	    String ret = null;
	    try {
	        ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
	    } 
	    catch (java.io.UnsupportedEncodingException e) {
	        return null;
	    }
	    return ret;
	}

}
