package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.base;

import io.appium.java_client.AppiumDriver;

public class DriverFactory {
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	
	
	public static AppiumDriver getDriver() {
		return driver.get();
			
	}
	
	public static void setDriver(AppiumDriver appiumDriver) {
		driver.set(appiumDriver);
	}

}
