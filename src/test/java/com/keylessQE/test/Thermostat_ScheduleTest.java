package com.keylessQE.test;

import com.keyless.pages.Login_Keyless;
import com.keyless.pages.ThermostatScheduler;
import com.keyless.utils.testUtils;
import com.keylessQE.menuPage;
import io.appium.java_client.AppiumDriver;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class Thermostat_ScheduleTest {

    static AppiumDriver driver;
    ThermostatScheduler thermShedlr;
    menuPage menupge;
    Login_Keyless loginpage;
    JSONObject loginusers;
    testUtils utils = new testUtils();

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
        thermShedlr = new ThermostatScheduler();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }

    @AfterMethod
    public void afterMethod() {
    }


    @AfterClass
    public void afterClass() {

    }

    @Test
    public void diableScheduler() throws Exception {
        thermShedlr.SlctScheduler();
        thermShedlr.disableScheduler();

    }

    @Test
    public void enableScheduler() throws Exception {
        thermShedlr.enableScheduler();
        Thread.sleep(3000);
    }

    @Test
    public void addEntry() throws Exception {
        thermShedlr.DtailoperatingMode();
        thermShedlr.AddNewSchdlr();
    }

    @Test
    public void chngeMode() throws Exception {
        thermShedlr.chngeScedlur();
        thermShedlr.chngeToCool();
        thermShedlr.ShdlrSave();
        thermShedlr.ShdlrnewSave();
    }


}
