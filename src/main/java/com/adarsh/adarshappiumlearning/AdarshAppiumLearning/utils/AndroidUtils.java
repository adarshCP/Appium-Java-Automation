package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidUtils {
	
	
	public static void scrollUsingAndroidUIAutomator(String name,AppiumDriver driver) {
		
		driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))" +
	            ".scrollIntoView(new UiSelector().text(\"" +name+ "\"))"
		        ));
		
		
	}
	
	public static void scrollUsingAndroidUIAutomatorByDescription(
	        String description, AppiumDriver driver) {

	    driver.findElement(
	        AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))"
	            + ".scrollIntoView(new UiSelector().description(\"" + description + "\"))"
	        )
	    );
	}

}
