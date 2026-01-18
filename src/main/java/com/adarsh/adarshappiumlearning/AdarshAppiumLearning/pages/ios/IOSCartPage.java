package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.ios;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base.BasePage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.CartPage;

import io.appium.java_client.AppiumDriver;

public class IOSCartPage extends BasePage implements CartPage {

	public IOSCartPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<WebElement> getCartItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItemFromCart(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPriceOFAnItem(String name) {
		// TODO Auto-generated method stub
		
	}

}
