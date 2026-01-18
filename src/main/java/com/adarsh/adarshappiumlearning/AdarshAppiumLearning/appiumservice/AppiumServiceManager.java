package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.appiumservice;

import java.io.File;
import java.net.URI;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.ConfigReader;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServiceManager {
	
	 private static AppiumDriverLocalService service;
	 
	 
	 public static void startAppium() {
		 
		 if(service ==null) {
			  try {
	                String serverUrl = System.getProperty("appiumServer") != null ? System.getProperty("appiumServer") : ConfigReader.get("appiumServer");
	                URI uri = URI.create(serverUrl);

	                String host = uri.getHost();
	                int port = uri.getPort();
	                
	                String appiumJsPath = System.getenv("APPIUM_JS_PATH") != null
	                        ? System.getenv("APPIUM_JS_PATH")
	                        : ConfigReader.get("appiumJsPath");

	                if (appiumJsPath == null || appiumJsPath.isBlank()) {
	                    throw new IllegalStateException(
	                            "Appium JS path not provided. Set APPIUM_JS_PATH or appiumJsPath"
	                    );
	                }
	                
	                File appiumJS = new File(appiumJsPath);

	                service = new AppiumServiceBuilder()
	                		.withAppiumJS(appiumJS)
	                        .withIPAddress(host)
	                        .usingPort(port)
	                        .build();
	                
	                service.start();
			  } catch (Exception e) {
	                throw new RuntimeException("Failed to start Appium service", e);
	            }
		 }
	 }
	 
	 public static void stopService() {
	        if (service != null) {
	            service.stop();
	            service = null;
	        }
	    }

}
