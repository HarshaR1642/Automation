package com.keylessQE.test;

import com.keyless.Other.RegionFilterForAssets;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class RegionFilterTest {

    JSONObject loginusers;
    RegionFilterForAssets regionFilter;

    @BeforeClass
    public void beforeClass() throws IOException {

        InputStream datails = null;
        try {
            String dataFileName = "Data/Loginuser.json";
            datails = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datails);
            loginusers = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datails != null) {
                datails.close();
            }
        }


    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        regionFilter = new RegionFilterForAssets();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test(priority = 57)
    public void regionFilterTestForAssets() throws Exception {
        regionFilter.RegionAndMarketFilter(false);
    }

    @Test(priority = 58)
    public void regionFilterTestForFreeDevices() throws Exception {
        regionFilter.RegionAndMarketFilter(true);
    }


}

