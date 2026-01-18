package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface CartPage {
	
	List<WebElement> getCartItems();
	void removeItemFromCart();
	
	String getProductTitle(String name);
	double getCartPriceOfAnItem();

}
