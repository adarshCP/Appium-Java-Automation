package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties props = new Properties();
	
	public static void loadConfig(String platform) {
		try {
            String path = System.getProperty("user.dir")
                    + "/src/test/resources/config/" + platform + ".properties";

            FileInputStream fis = new FileInputStream(path);
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
	}
	
	public static String get(String key) {
        return props.getProperty(key);
    }
	
	

}
