package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Properties;

public class AndroidDriverManager {
	public static AppiumDriver createDriver() throws MalformedURLException {
		
		 UiAutomator2Options options = new UiAutomator2Options();

	        options.setPlatformName("Android");
	        options.setDeviceName(ConfigReader.get("deviceName"));
	        options.setAutomationName("UiAutomator2");
       
        
        String appPath = System.getProperty("user.dir")
                + "/" + ConfigReader.get("appPath");
        options.setApp(appPath);
        
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
        String serverUrl = System.getProperty("appiumServer") != null ? System.getProperty("appiumServer") : ConfigReader.get("appiumServer");
        URI uri = URI.create(serverUrl);
        return new AndroidDriver(uri.toURL(), options);
	}
	
}


