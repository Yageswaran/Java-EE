/**
 * 
 */
package com.sicmsb.tsapp.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Design Pattern : Singleton
 * 
 * @author yageswaran.ramar
 * 
 */
public class Config {

	private static Config instance = new Config();
	private Properties prop;

	/**
	 * 
	 * @return
	 */
	public static final Config getInstance() {
		return instance;
	}

	private Config() {
		init();
	}

	private void init() {
		try {
			prop = new Properties();
			InputStream is = getClass().getResourceAsStream(
					"/config.properties");
			prop.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			// logger here later
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getProperty(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}

}
