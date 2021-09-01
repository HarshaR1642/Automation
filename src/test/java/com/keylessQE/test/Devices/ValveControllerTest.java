package com.keylessQE.test.Devices;
import com.keyless.Devices.ValveControllerDetail;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ValveControllerTest {

    JSONObject loginusers;
    ValveControllerDetail valveControllerDetail;

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
        valveControllerDetail = new ValveControllerDetail();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void valveControllerTest1() throws Exception {
        Thread.sleep(1000);
        valveControllerDetail.navigateToValveController();
        String time = null;
        if (valveControllerDetail.getState().equals("on")) {
            time = valveControllerDetail.clickToOff();
            valveControllerDetail.clickOnValveControllerActivityTab();
            valveControllerDetail.checkActivity("off", time);
            valveControllerDetail.clickOnValveControllerDetailsTab();
        } else {
            time = valveControllerDetail.clickToOn();
            valveControllerDetail.clickOnValveControllerActivityTab();
            valveControllerDetail.checkActivity("on", time);
            valveControllerDetail.clickOnValveControllerDetailsTab();
        }
    }

    @Test
    public void valveControllerTest2() throws Exception {
        Thread.sleep(1000);
        String time = null;
        if (valveControllerDetail.getState().equals("on")) {
            time = valveControllerDetail.clickToOff();
            valveControllerDetail.clickOnValveControllerActivityTab();
            valveControllerDetail.checkActivity("off", time);
            valveControllerDetail.clickOnValveControllerDetailsTab();
            valveControllerDetail.navigateBack();
        } else {
            time = valveControllerDetail.clickToOn();
            valveControllerDetail.clickOnValveControllerActivityTab();
            valveControllerDetail.checkActivity("on", time);
            valveControllerDetail.clickOnValveControllerDetailsTab();
            valveControllerDetail.navigateBack();
        }
    }


}

