package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.base.BaseTest;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pageprovider.PageProvider;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.CartPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.LoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PDPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PLPPage;

public class EcommerceTests2 extends BaseTest {

    private static final String PRODUCT_NAME ="Sauce Labs Onesie";

    @BeforeMethod(alwaysRun = true)
    public void login() {
        LoginPage loginPage = PageProvider.loginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void should_DisplayProductTitles_OnPLP() {
        PLPPage plpPage = PageProvider.plpPage(driver);

        boolean isProductTitleDisplayed = plpPage.isAProductTitleDisplayed();

        Assert.assertTrue(isProductTitleDisplayed,
                "Product titles are not displayed on PLP");
    }

    @Test
    public void should_DisplayProductTitle_OnPDP() {
        navigateToPDP(PRODUCT_NAME);

        PDPPage pdpPage = PageProvider.pdpPage(driver);
        boolean isProductTitleDisplayed = pdpPage.isProductTitleDisplayed();

        Assert.assertTrue(isProductTitleDisplayed,
                "Product title is not displayed on PDP");
    }

    @Test
    public void should_DisplayAddedItem_InCart() {
        navigateToPDP(PRODUCT_NAME);

        PDPPage pdpPage = PageProvider.pdpPage(driver);
        pdpPage.addToCartfromPDP();
        pdpPage.navigateToCartPage();

        CartPage cartPage = PageProvider.cartPage(driver);
        String productTitle = cartPage.getProductTitle(PRODUCT_NAME);

        Assert.assertEquals(productTitle, PRODUCT_NAME,
                "Added product is not visible in cart");
    }

    @Test
    public void should_RemoveItem_FromCart() {
        navigateToPDP(PRODUCT_NAME);

        PDPPage pdpPage = PageProvider.pdpPage(driver);
        pdpPage.addToCartfromPDP();
        pdpPage.navigateToCartPage();

        CartPage cartPage = PageProvider.cartPage(driver);
        cartPage.removeItemFromCart();

        Assert.assertTrue(cartPage.getCartItems().isEmpty(),
                "Cart is not empty after removing the item");
    }

    @Test
    public void should_MatchPrice_BetweenPDPAndCart() {
        navigateToPDP(PRODUCT_NAME);

        PDPPage pdpPage = PageProvider.pdpPage(driver);
        double pdpPrice = pdpPage.getPDPProductPrice();

        pdpPage.addToCartfromPDP();
        pdpPage.navigateToCartPage();

        CartPage cartPage = PageProvider.cartPage(driver);
        double cartPrice = cartPage.getCartPriceOfAnItem();
       
        Assert.assertEquals(cartPrice, pdpPrice,
                "Product price mismatch between PDP and Cart");
    }

    /* ----------------- Helper Methods ----------------- */

    private void navigateToPDP(String productName) {
        PLPPage plpPage = PageProvider.plpPage(driver);
        plpPage.navigateToPDPOfAProduct(productName);
    }
}
