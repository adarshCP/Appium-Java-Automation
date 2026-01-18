package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base.BasePage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.LoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PDPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PLPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.AndroidUtils;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.WaitUtils;

import io.appium.java_client.AppiumDriver;

public class AndroidPDPPage extends BasePage implements PDPPage{
	
	
	
	
	

	public AndroidPDPPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public By productTitle= By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
	
	public By productAddtoCartButton=By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]");
	
	public By productPriceElement=By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");

	public By navigateToCartButton=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]");
	@Override
	public void addToCartfromPDP() {
		// TODO Auto-generated method stub
		AndroidUtils.scrollUsingAndroidUIAutomatorByDescription("test-ADD TO CART",driver);
		tap(productAddtoCartButton);
		
		
	}

	@Override
	public boolean isProductTitleDisplayed() {
		wait.waitUntilanElementIsVisibile(productTitle);
		
		return driver.findElement(productTitle).isDisplayed();
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateToCartPage() {
		// TODO Auto-generated method stub
		tap(navigateToCartButton);
		
	}

	@Override
	public double getPDPProductPrice() {
		
		// TODO Auto-generated method stub
		wait.waitUntilanElementIsVisibile(productPriceElement);
		String productPrice=driver.findElement(productPriceElement).getText();
		return getformattedProductPrice(productPrice);
		
	}

	

	
	

}
