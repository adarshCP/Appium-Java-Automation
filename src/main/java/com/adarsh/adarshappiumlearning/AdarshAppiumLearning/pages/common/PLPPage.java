package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface PLPPage {
	
	
	boolean isAProductTitleDisplayed();
	
	void addProductToCart(String productName);
	
	void navigateToPDPOfAProduct(String productName);
	

}
