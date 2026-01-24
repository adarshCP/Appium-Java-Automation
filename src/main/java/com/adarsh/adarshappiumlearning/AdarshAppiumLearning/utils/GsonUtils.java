package com.adarsh.adarshappiumlearning.AdarshAppiumLearning.utils;

import java.io.FileReader;
import java.util.List;

import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.datamodel.EcommerceData;
import com.adarsh.adarshappiumlearning.AdarshAppiumLearning.datamodel.EcommerceDataWrapper;
import com.google.gson.Gson;

public class GsonUtils {
	
	 /**
     * Reads ecommerce JSON test data and converts it into Object[][]
     * for TestNG DataProvider
     */
	
	public static Object[][] getEcommerceData(String path) {

        try (FileReader reader = new FileReader(path)) {

            Gson gson = new Gson();
            EcommerceDataWrapper wrapper =
                    gson.fromJson(reader, EcommerceDataWrapper.class);

            List<EcommerceData> list = wrapper.getEcommerceTests();
            Object[][] data = new Object[list.size()][1];

            for (int i = 0; i < list.size(); i++) {
                data[i][0] = list.get(i);
            }
            return data;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read ecommerce JSON", e);
        }	
    }

}
