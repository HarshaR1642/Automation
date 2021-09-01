package com.keylessQE.test.ManageTab;

import com.keyless.AccountTab.UserGuide;
import com.keyless.ManageTab.HomeDetails;
import com.keyless.pages.Login_Keyless;
import com.keyless.pages.Select_Home;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class HomeDetailsTest {

    JSONObject loginusers;
    HomeDetails homeDetails;
    Login_Keyless loginpage;
    UserGuide KeylessUserGuide;
    Select_Home selectHome;

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
        homeDetails = new HomeDetails();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test(priority = 31)
    public void updateHomeDetails() throws Exception {

        homeDetails.clickOnManageTab();
        homeDetails.clickOnHomeDetails();
        homeDetails.updateHomeName("RS Prod");
//        homeDetails.updateAddress("2331 Borchard Road");
//        homeDetails.updateCity("Thousand Oaks");
//        homeDetails.updateState("CA");
//        homeDetails.updateZipCode("91320");
//        homeDetails.updateLatitude("34.1810666");
//        homeDetails.updateLongitude("-118.9470422");
        homeDetails.save();
        homeDetails.checkAlertTitle();
        homeDetails.checkAlertMessage();
        homeDetails.clickOk();
        homeDetails.navigateBack();
        homeDetails.clickOnHomeTab();
        homeDetails.checkHomeNameInDashboard();
    }

}

