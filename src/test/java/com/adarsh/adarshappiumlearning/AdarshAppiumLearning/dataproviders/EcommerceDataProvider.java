package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.dataproviders;

import org.testng.annotations.DataProvider;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils.GsonUtils;

public class EcommerceDataProvider {

	@DataProvider (name = "ecommerceData")
	public Object[][] ecommerceDataProvider() {
		{
			return GsonUtils.getEcommerceData("src/test/resources/testdata/LoginTestData.json");

		}

	}

}