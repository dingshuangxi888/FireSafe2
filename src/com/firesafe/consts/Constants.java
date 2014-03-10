package com.firesafe.consts;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Constants {

	public static String URL_NCWS = null;
	
	static {
		InputStream is = Constants.class.getClassLoader().getResourceAsStream("constants.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
			URL_NCWS = prop.getProperty("URL_NCWS");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
