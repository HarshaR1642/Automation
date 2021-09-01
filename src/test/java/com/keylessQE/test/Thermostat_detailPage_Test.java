package com.keylessQE.test;

import com.keyless.pages.Login_Keyless;
import com.keyless.pages.Thermostat_detail;
import com.keyless.utils.testUtils;
import com.keylessQE.BaseTest;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class Thermostat_detailPage_Test extends BaseTest {

    Thermostat_detail thermDetail;
    JSONObject loginusers;
    testUtils utils = new testUtils();
    Login_Keyless loginpage;

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


    @AfterClass
    public void afterClass() {

    }


    @BeforeMethod
    public void beforeMethod(Method m) {
        thermDetail = new Thermostat_detail();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test(priority = 23)
    public void selectThermostat() throws Exception {

        thermDetail.tapDshBrdModeBtn();

    }

    @Test(priority = 24)
    public void ChngModeAuto() throws Exception {
        thermDetail.tapOperateModeBtn();
        thermDetail.tapHeatModeBtn();
        thermDetail.tapSaveBtn();
        Thread.sleep(5000);
    }

    @Test(priority = 25)
    public void ChngFanModeAuto() throws Exception {
        thermDetail.FanMode();
        thermDetail.FanModeAuto();
        Thread.sleep(5000);
    }

    @Test(priority = 26)
    public void ChngFanModeON() throws Exception {
        thermDetail.FanMode();
        thermDetail.FanModeOn();
        Thread.sleep(5000);
    }


}
