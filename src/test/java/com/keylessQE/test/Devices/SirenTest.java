package com.keylessQE.test.Devices;

import com.keyless.Devices.Siren;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SirenTest {

    JSONObject loginusers;
    Siren siren;

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
        siren = new Siren();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test(priority = 49)
    public void SirenTest1() throws Exception {
        Thread.sleep(1000);
        siren.navigateToSirenDevice();
        ;
        String time = null;
        if (siren.getState().equals("on")) {
            time = siren.clickToStop();
            siren.clickOnSirenActivityTab();
            siren.checkActivity("off", time);
            siren.clickOnSirenDetailsTab();
        } else {
            time = siren.clickToTest();
            siren.clickOnSirenActivityTab();
            siren.checkActivity("on", time);
            siren.clickOnSirenDetailsTab();
        }
    }

    @Test(priority = 50)
    public void SirenTest2() throws Exception {
        Thread.sleep(1000);
        String time = null;
        if (siren.getState().equals("on")) {
            time = siren.clickToStop();
            siren.clickOnSirenActivityTab();
            siren.checkActivity("off", time);
            siren.clickOnSirenDetailsTab();
            siren.navigateBack();
        } else {
            time = siren.clickToTest();
            siren.clickOnSirenActivityTab();
            siren.checkActivity("on", time);
            siren.clickOnSirenDetailsTab();
            siren.navigateBack();
        }
    }


}

