package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base.BasePage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.LoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.AndroidUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidLoginPage extends BasePage implements LoginPage{

	public AndroidLoginPage(AppiumDriver driver) {
        super(driver);
    }
	
	public By userNameField =AppiumBy.accessibilityId("test-Username");
	public By passwordField =AppiumBy.accessibilityId("test-Password");
	public By loginButton =By.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
	
	@Override
	public void login(String username , String password) {
		
		type(userNameField,username);
		type(passwordField,password);
		tap(loginButton);
		
		// TODO Auto-generated method stub	
		
	}
	

   
			
	
	

}
