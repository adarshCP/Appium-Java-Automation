package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.AndroidUtils;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.WaitUtils;

import io.appium.java_client.AppiumDriver;

public abstract class BasePage {
	protected AppiumDriver driver;
    protected WaitUtils wait;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    
    protected void type(By locator, String text) {
        wait.sendKeys(locator, text);
    }

    protected void tap(By locator) {
        wait.click(locator);
    }
    
    
    
    protected double getformattedProductPrice(String productPrice) {
		String splittedString = productPrice.substring(1);
		Double price=Double.parseDouble(splittedString);
		return price;
		
	}
    
    
    
}
