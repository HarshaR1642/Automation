package com.keylessQE.test.AccountTab;

import com.keyless.AccountTab.Support;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SupportScreenTest {

    JSONObject loginusers;
    Support support;

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
        support = new Support();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void helpArticleSupport() throws Exception {
        support.tapOnAccountTab();
        support.tapOnSupport();
        support.helpArticleSupport();
    }

    @Test
    public void phoneSupport() throws Exception {
        support.phoneSupport();
    }

    @Test
    public void emailSupport() throws Exception {
        support.emailSupport();
        support.navigateBack();
    }


}
