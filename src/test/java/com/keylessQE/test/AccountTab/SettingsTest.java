package com.keylessQE.test.AccountTab;

import com.keyless.AccountTab.Settings;
import com.keyless.utils.testUtils;
import com.keylessQE.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SettingsTest extends BaseTest {
    static AppiumDriver driver;
    JSONObject loginusers;
    Settings settings;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

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
        settings = new Settings();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }


    @Test(priority = 18)
    public void settings() throws Exception {

        settings.tapOnAccountTab();
        settings.tapOnSettings();
        settings.toggleEmail();
        settings.togglePushNotification();
        settings.toggleNotifyAllUnlock();
        settings.toggleRoutines();
        settings.toggleNotifyContactSensor();
        settings.toggleFaceID();
        settings.navigateBack();
    }

}
