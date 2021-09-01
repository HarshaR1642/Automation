package com.keylessQE.test.Devices;

import com.keyless.Devices.GarageDoorDetail;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class GarageDoorTest {

    JSONObject loginusers;
    GarageDoorDetail garageDoorDetail;

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
        garageDoorDetail = new GarageDoorDetail();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void garageDoorTest() throws Exception {
        Thread.sleep(1000);
        garageDoorDetail.navigateToGarageDoor();
        String time = null;
        if (garageDoorDetail.getState().equals("open")) {
            time = garageDoorDetail.clickToClose();
            garageDoorDetail.clickOnGarageDoorActivityTab();
            garageDoorDetail.checkActivity("close", time);
            garageDoorDetail.clickOnGarageDoorDetailsTab();
        } else {
            time = garageDoorDetail.clickToOpen();
            garageDoorDetail.clickOnGarageDoorActivityTab();
            garageDoorDetail.checkActivity("open", time);
            garageDoorDetail.clickOnGarageDoorDetailsTab();
        }
    }


}

