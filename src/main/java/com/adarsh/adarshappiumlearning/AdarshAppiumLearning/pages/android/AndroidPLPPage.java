package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.base.BasePage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.LoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PLPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.AndroidUtils;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.WaitUtils;

import io.appium.java_client.AppiumDriver;

public class AndroidPLPPage extends BasePage implements PLPPage{
	

	public AndroidPLPPage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public By productCard =By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])");
	
	public By productTitleElement =By.xpath(".//android.widget.TextView[@content-desc=\"test-Item title\"]");
	
	public By productAddToCartButton=By.xpath(".//android.view.ViewGroup[@content-desc='test-ADD TO CART' or @content-desc='test-REMOVE']");
	public List<WebElement> getProductCards() {
		return driver.findElements(productCard);
		
	}
	
	public List<WebElement> getProductNames() {
		return driver.findElements(productTitleElement);
		
	}
	
	
	
	
	@Override
	public void addProductToCart(String productName) {
		AndroidUtils.scrollUsingAndroidUIAutomator(productName,driver);	
		for(int i=0; i<getProductCards().size();i++) {
			WebElement productCard=getProductCards().get(i);
			String productName1=productCard.findElement(productTitleElement).getText();
			
			if (productName1.equalsIgnoreCase(productName)) {
				productCard.findElement(productAddToCartButton).click();
			}
			
		}
		
		
	}


	
	
	
	
	
	@Override
	public  boolean isAProductTitleDisplayed() {
		
		wait.waitUntilanElementIsVisibile(productTitleElement);
		
		List<WebElement> productNames = getProductNames();
		

	    if (productNames.isEmpty()) 
	    {
	        return false;
	    } 
		
	    for (WebElement product : productNames) {
	        if (product.isDisplayed()) {
	            return true;
	        }
	    }
		return false;
	    
		
	
	
	}

	@Override
	public void navigateToPDPOfAProduct(String productName1) {
		
		AndroidUtils.scrollUsingAndroidUIAutomator(productName1,driver);
		wait.waitUntilanElementIsVisibile(productCard);
		
		List <WebElement> productCards =getProductCards();
		
		for(int i=0; i<productCards.size();i++) {
			WebElement productCard=getProductCards().get(i);
			String productName2=productCard.findElement(productTitleElement).getText();
			
			if (productName2.equalsIgnoreCase(productName1)) {
				productCard.click();
				return;
			}
			
		}
		
		// TODO Auto-generated method stub
		
	}
	
	

	

}
