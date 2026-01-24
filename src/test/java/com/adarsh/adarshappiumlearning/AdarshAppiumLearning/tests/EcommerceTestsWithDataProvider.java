package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.base.BaseTest;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.datamodel.EcommerceData;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.dataproviders.EcommerceDataProvider;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pageprovider.PageProvider;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.CartPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.LoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PDPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PLPPage;

public class EcommerceTestsWithDataProvider extends BaseTest {

	@Test(dataProvider = "ecommerceData", dataProviderClass = EcommerceDataProvider.class)
	public void should_DisplayProductTitles_OnPLP(EcommerceData data) {
		login(data);
		PLPPage plpPage = PageProvider.plpPage(driver);

		boolean isProductTitleDisplayed = plpPage.isAProductTitleDisplayed();

		Assert.assertTrue(isProductTitleDisplayed, "Product titles are not displayed on PLP");
	}

	@Test(dataProvider = "ecommerceData", dataProviderClass = EcommerceDataProvider.class)
	public void should_DisplayProductTitle_OnPDP(EcommerceData data) {
		login(data);
		navigateToPDP(data);

		PDPPage pdpPage = PageProvider.pdpPage(driver);
		boolean isProductTitleDisplayed = pdpPage.isProductTitleDisplayed();

		Assert.assertTrue(isProductTitleDisplayed, "Product title is not displayed on PDP");
	}

	@Test(dataProvider = "ecommerceData", dataProviderClass = EcommerceDataProvider.class)
	public void should_DisplayAddedItem_InCart(EcommerceData data) {
		login(data);
		navigateToPDP(data);

		PDPPage pdpPage = PageProvider.pdpPage(driver);
		pdpPage.addToCartfromPDP();
		pdpPage.navigateToCartPage();

		CartPage cartPage = PageProvider.cartPage(driver);
		String productTitle = cartPage.getProductTitle(data.getProductName());

		Assert.assertEquals(productTitle, data.getProductName(), "Added product is not visible in cart");
	}

	@Test(dataProvider = "ecommerceData", dataProviderClass = EcommerceDataProvider.class)
	public void should_RemoveItem_FromCart(EcommerceData data) {
		login(data);
		navigateToPDP(data);

		PDPPage pdpPage = PageProvider.pdpPage(driver);
		pdpPage.addToCartfromPDP();
		pdpPage.navigateToCartPage();

		CartPage cartPage = PageProvider.cartPage(driver);
		cartPage.removeItemFromCart();

		Assert.assertTrue(cartPage.getCartItems().isEmpty(), "Cart is not empty after removing the item");
	}

	@Test(dataProvider = "ecommerceData", dataProviderClass = EcommerceDataProvider.class)
	public void should_MatchPrice_BetweenPDPAndCart(EcommerceData data) {
		login(data);
		navigateToPDP(data);

		PDPPage pdpPage = PageProvider.pdpPage(driver);
		double pdpPrice = pdpPage.getPDPProductPrice();

		pdpPage.addToCartfromPDP();
		pdpPage.navigateToCartPage();

		CartPage cartPage = PageProvider.cartPage(driver);
		double cartPrice = cartPage.getCartPriceOfAnItem();

		Assert.assertEquals(cartPrice, pdpPrice, "Product price mismatch between PDP and Cart");
	}

	/* ----------------- Helper Methods ----------------- */

	private void login(EcommerceData data) {

		LoginPage loginPage = PageProvider.loginPage(driver);
		loginPage.login(data.getUserName(), data.getPassword());
	}

	private void navigateToPDP(EcommerceData data) {

		PLPPage plpPage = PageProvider.plpPage(driver);
		plpPage.navigateToPDPOfAProduct(data.getProductName());
	}
}
