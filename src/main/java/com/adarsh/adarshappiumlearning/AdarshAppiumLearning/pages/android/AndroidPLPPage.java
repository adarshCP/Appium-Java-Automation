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
	
	// Product card container
	private By productCard =By.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
	
	// Product title inside a card (relative locator)
	public By productTitleElement =By.xpath(".//android.widget.TextView[@content-desc=\"test-Item title\"]");
	

    // Add / Remove button inside a card (relative locator)
	public By productAddToCartButton=By.xpath(".//android.view.ViewGroup[@content-desc='test-ADD TO CART' or @content-desc='test-REMOVE']");
	
	
	   /* =======================
    Helper methods
    ======================= */
	
	public List<WebElement> getProductCards() {
		return driver.findElements(productCard);
		
	}
	
	public List<WebElement> getProductNames() {
		return  getProductCards().stream()
	            .map(card -> card.findElement(productTitleElement))
	            .toList();
		
	}
	
	private WebElement getProductCardByName(String productName) {
		AndroidUtils.scrollUsingAndroidUIAutomator(productName,driver);
		
		for (WebElement card:getProductCards() ) {
			String name=card.findElement(productTitleElement).getText();
			if (name.equalsIgnoreCase(productName)) {
				return card;
			}
			
		}
		return null;
		
	}
	
	
	/* =======================
    PLPPage Implementations
    ======================= */
	
	@Override
	public void addProductToCart(String productName) {
		WebElement productCard =getProductCardByName(productName);
		wait.waitUtilAnElementIsClickable(productCard);
		if (productCard == null) {
            throw new RuntimeException("Product not found on PLP: " + productName);
        }
		productCard.findElement(productAddToCartButton).click();
		
			
		}
		
		
	
	@Override
	public  boolean isAProductTitleDisplayed() {
		
		 wait.waitUntilanElementIsVisibile(productTitleElement);

		    for (WebElement title : getProductNames()) {
		        if (title.isDisplayed()) {
		            return true;
		        }
		    }
		    return false;
	    
		
	
	
	}

	@Override
	public void navigateToPDPOfAProduct(String productName) {
		WebElement productCard =getProductCardByName(productName);
		
		if (productCard == null) {
            throw new RuntimeException("Product not found on PLP: " + productName);
        }
		productCard.click();
		
		}
		
		// TODO Auto-generated method stub
		
	}
	
	

	


