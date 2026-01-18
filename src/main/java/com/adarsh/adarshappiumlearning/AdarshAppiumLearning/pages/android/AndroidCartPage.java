package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base.BasePage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.CartPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.WaitUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidCartPage extends BasePage implements  CartPage{

	public AndroidCartPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By cartItem =By.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
	
	
	By removeItem=By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]");

	By itemPriceElement=By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
    @Override
    public void removeItemFromCart() {
    	tap(removeItem);
        
    }



	@Override
	public List<WebElement> getCartItems() {
		return driver.findElements(cartItem);
	}
	
	@Override
	public String getProductTitle(String name){
		 String actualProductname=driver.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']")).getText();
		return actualProductname;
		
	}


	@Override
	public double getCartPriceOfAnItem() {
		// TODO Auto-generated method stub
		
		String cartProductPrice =driver.findElement(itemPriceElement).getText();
		return getformattedProductPrice(cartProductPrice);
		
	}



	
}
