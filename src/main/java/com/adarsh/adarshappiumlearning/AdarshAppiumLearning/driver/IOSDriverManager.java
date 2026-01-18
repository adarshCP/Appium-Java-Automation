package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.driver;

import java.net.URI;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSDriverManager {
	 public static AppiumDriver createDriver() throws Exception {
		 XCUITestOptions options = new XCUITestOptions();
	        options.setDeviceName(ConfigReader.get("deviceName"));
	        options.setPlatformVersion(ConfigReader.get("platformVersion"));
	        options.setAutomationName(ConfigReader.get("automationName"));
	        options.setApp(System.getProperty("user.dir") + "/" + ConfigReader.get("appPath"));

	        return new IOSDriver(
	                URI.create(ConfigReader.get("appiumServer")).toURL(),
	                options
	        );
	    }

}
