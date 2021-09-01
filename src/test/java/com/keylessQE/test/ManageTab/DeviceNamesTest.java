package com.keylessQE.test.ManageTab;

import com.keyless.ManageTab.DeviceNames;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class DeviceNamesTest {

    JSONObject loginusers;
    DeviceNames deviceNames;

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
        deviceNames = new DeviceNames();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void deviceNamesTest() throws Exception {
        deviceNames.clickOnManageTab();
        deviceNames.clickOnDeviceNames();
        deviceNames.updateDeviceNames();
    }


}

