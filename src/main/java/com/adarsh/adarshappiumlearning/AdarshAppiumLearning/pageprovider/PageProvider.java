package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pageprovider;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android.AndroidCartPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android.AndroidLoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android.AndroidPLPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.android.AndroidPDPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.CartPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.LoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PDPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.common.PLPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.ios.IOSCartPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.ios.IOSLoginPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.ios.IOSPDPPage;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.pages.ios.IOSPLPPage;

import io.appium.java_client.AppiumDriver;


public final class PageProvider {

    private PageProvider() {
        // prevent instantiation
    }

    private static String getPlatform(AppiumDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }

        return driver.getCapabilities()
                .getPlatformName()
                .toString()
                .toLowerCase();
    }

    public static LoginPage loginPage(AppiumDriver driver) {
        String platform = getPlatform(driver);

        if (platform.equals("android")) {
            return new AndroidLoginPage(driver);
        }
        if (platform.equals("ios")) {
            return new IOSLoginPage(driver);
        }

        throw new IllegalStateException("Unsupported platform: " + platform);
    }

    public static PLPPage plpPage(AppiumDriver driver) {
        String platform = getPlatform(driver);

        if (platform.equals("android")) {
            return new AndroidPLPPage(driver);
        }
        if (platform.equals("ios")) {
            return new IOSPLPPage(driver);
        }

        throw new IllegalStateException("Unsupported platform: " + platform);
    }
    
    public static PDPPage pdpPage(AppiumDriver driver) {
        String platform = getPlatform(driver);

        if (platform.equals("android")) {
            return new AndroidPDPPage(driver);
        }
        if (platform.equals("ios")) {
            return new IOSPDPPage(driver);
        }

        throw new IllegalStateException("Unsupported platform: " + platform);
    }
    
    public static CartPage cartPage(AppiumDriver driver) {
        String platform = getPlatform(driver);

        if (platform.equals("android")) {
            return new AndroidCartPage(driver);
        }
        if (platform.equals("ios")) {
            return new IOSCartPage(driver);
        }

        throw new IllegalStateException("Unsupported platform: " + platform);
    }
}