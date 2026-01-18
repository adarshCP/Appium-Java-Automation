package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.base;

public class PlatformManager {
	
	public static String getPlatform() {
		return	System.getProperty("platform","android");
		
	}
	
	

}
