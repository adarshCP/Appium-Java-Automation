package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.appiumservice.AppiumServiceManager;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.driver.AndroidDriverManager;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.driver.IOSDriverManager;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;


public class BaseTest {
		
	protected AppiumDriver driver;
	
	protected String platform;
	
	
	@BeforeSuite (alwaysRun = true)
	public void startAppiumServer() {
		
		 platform = PlatformManager.getPlatform();

	        if (platform == null || platform.isBlank()) {
	            throw new IllegalStateException(
	                    "Platform not specified. Use -Dplatform=android or -Dplatform=ios"
	            );
	        }
	        ConfigReader.loadConfig(platform);

		
		AppiumServiceManager.startAppium();
		
	}
	
	 @BeforeClass (alwaysRun = true)
	  public void initPlatform() {
	        // Ensure instance variable is always set
	        this.platform = PlatformManager.getPlatform();
	    }
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception {
        
        driver = platform.equalsIgnoreCase("android")
                ? AndroidDriverManager.createDriver()
                : IOSDriverManager.createDriver();
		DriverFactory.setDriver(driver);
		
	}
	
	@AfterMethod (alwaysRun = true)
    public void tearDown() {
		if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
        }
    }
	
	@AfterSuite (alwaysRun = true)
	public static void stopAppiumServer() {
		AppiumServiceManager.stopService();
        }
    }
	
	
	
	


