package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common;

public interface PDPPage {
	
	boolean isProductTitleDisplayed();
	
	void addToCartfromPDP();
	
	void navigateToCartPage();
	
	double getPDPProductPrice();

}
