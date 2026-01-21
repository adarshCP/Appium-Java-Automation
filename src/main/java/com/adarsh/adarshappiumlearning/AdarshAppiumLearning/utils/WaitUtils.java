package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class WaitUtils {
	
	private WebDriverWait wait;
	
	 public WaitUtils(AppiumDriver driver) {
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	 
	 
	 public void waitUntilanElementIsVisibile(By locator) {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 }
	 
	 public void waitUtilAnElementIsClickable(WebElement productCard) {
		 wait.until(ExpectedConditions.elementToBeClickable(productCard));
	 }
	 public void click(By locator) {
	        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	    }
	 
	 public void sendKeys(By locator, String text) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
	            .sendKeys(text);
	    }
	
	

}
