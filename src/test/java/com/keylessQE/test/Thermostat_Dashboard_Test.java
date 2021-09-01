package com.keylessQE.test;

import com.keyless.pages.Login_Keyless;
import com.keyless.pages.Thermostat;
import com.keyless.utils.testUtils;
import com.keylessQE.BaseTest;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class Thermostat_Dashboard_Test extends BaseTest {
    Login_Keyless loginpage;
    Thermostat themostat_dash;
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

    @AfterClass
    public void afterClass() {

    }


    @BeforeMethod
    public void beforeMethod(Method m) {
        themostat_dash = new Thermostat();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test(priority = 18)
    public void AutoModeScreenText() throws Exception {
        loginpage = new Login_Keyless();
        themostat_dash = loginpage.taponLoginAsResident3();
        themostat_dash = loginpage.login_2(loginusers.getJSONObject("valid_usrId_pswd").getString("username"),
                loginusers.getJSONObject("valid_usrId_pswd").getString("password"));
        themostat_dash.tapSlcthome();
        SoftAssert sa = new SoftAssert();
        themostat_dash.tapDshBrdModeBtn();
        themostat_dash.tapAutoModeBtn();
        String actualErrtxt = themostat_dash.chnagewindowTxt();
        sa.assertEquals(actualErrtxt, getStrings().get("Change Thermostat Titltxt"));
        sa.assertAll();
        themostat_dash.tapCloseBtn();


    }


    @Test(priority = 19)
    public void ChngeAutoModeBtn() throws Exception {
        Thread.sleep(2000);
        themostat_dash.tapDshBrdModeBtn();
        //	  SoftAssert sa = new SoftAssert();

        themostat_dash.tapAutoModeBtn();
        Thread.sleep(2000);
        themostat_dash.scroll(509, 848, 970, 922);
        themostat_dash.scroll(511, 1239, 171, 1313);
        themostat_dash.tapSaveBtn();
        Thread.sleep(4000);
    }

    @Test(priority = 20)
    public void ChngeHeatModeBtn() throws Exception {
        Thread.sleep(4000);
        themostat_dash.tapDshBrdModeBtn();
        themostat_dash.tapHeatModeBtn();
        themostat_dash.scroll(509, 1239, 912, 1239);
        themostat_dash.tapSaveBtn();
        Thread.sleep(4000);
    }

    @Test(priority = 21)
    public void ChngeCoolModeBtn() throws Exception {
        Thread.sleep(3000);
        themostat_dash.tapDshBrdModeBtn();
        themostat_dash.tapCoolModeBtn();
        themostat_dash.scroll(512, 848, 910, 1000);
        Thread.sleep(2000);
        themostat_dash.tapSaveBtn();
        Thread.sleep(3000);
    }

    @Test(priority = 22)
    public void OffModeBtn() throws Exception {
        Thread.sleep(3000);
        themostat_dash.tapDshBrdModeBtn();
        themostat_dash.tapOffModeBtn();
        Thread.sleep(2000);
        themostat_dash.tapSaveBtn();
        Thread.sleep(3000);
    }


}
