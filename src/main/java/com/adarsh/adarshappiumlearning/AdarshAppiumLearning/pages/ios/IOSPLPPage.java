package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.ios;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base.BasePage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PLPPage;

import io.appium.java_client.AppiumDriver;

public class IOSPLPPage extends BasePage implements PLPPage {

	public IOSPLPPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAProductTitleDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addProductToCart(String productName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateToPDPOfAProduct(String productName) {
		// TODO Auto-generated method stub
		
	}

	
}
