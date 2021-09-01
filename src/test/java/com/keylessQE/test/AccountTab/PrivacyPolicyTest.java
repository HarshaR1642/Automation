package com.keylessQE.test.AccountTab;

import com.keyless.AccountTab.PrivacyPolicy;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class PrivacyPolicyTest {

    JSONObject loginusers;
    PrivacyPolicy privacyPolicy;

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
        privacyPolicy = new PrivacyPolicy();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test(priority = 27)
    public void privacyPolicyTest() throws Exception {

        privacyPolicy.tapOnAccountTab();
        privacyPolicy.tapOnPrivacypolicy();
        privacyPolicy.checkForPrivacyPolicyMobileView();
        privacyPolicy.navigateBack();
    }


}
