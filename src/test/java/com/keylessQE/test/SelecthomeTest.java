package com.keylessQE.test;

import com.keyless.AccountTab.UserGuide;
import com.keyless.pages.Account_tab;
import com.keyless.pages.Login_Keyless;
import com.keyless.pages.Select_Home;
import com.keyless.utils.testUtils;
import com.keylessQE.BaseTest;
import com.keylessQE.menuPage;
import io.appium.java_client.AppiumDriver;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SelecthomeTest extends BaseTest {

    static AppiumDriver driver;
    Select_Home slecthome;
    Login_Keyless loginpage;
    UserGuide KeylessUserGuide;
    Select_Home selectHome;
    Account_tab acountpage;
    menuPage menupge;
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
        closeApp();
        launchApp();

    }

    @AfterClass
    public void afterClass() {

    }


    @BeforeMethod
    public void beforeMethod(Method m) {
        selectHome = new Select_Home();
        KeylessUserGuide = new UserGuide();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }

    @AfterMethod
    public void afterMethod() {
    }


    //	  @Test(priority=16)
    //	  public void selectHometxt()
    //	  {
    //		  SoftAssert sa = new SoftAssert();
    //		  String SelectHometxt = selectHome.SelectHometxt();
    //		  sa.assertEquals(SelectHometxt, strings.get("select Home Title"));
    //		  sa.assertAll();
    //	  }
    //
    @Test(priority = 10)
    public void selectHome() throws Exception {
        loginpage = new Login_Keyless();
        selectHome = loginpage.taponLoginAsResident1();
        selectHome = loginpage.login_1(loginusers.getJSONObject("valid_usrId_pswd").getString("username"),
                loginusers.getJSONObject("valid_usrId_pswd").getString("password"));
        //selectHome=loginpage.LoginBtn_tap();
        Thread.sleep(3000);
        selectHome = KeylessUserGuide.skipUsrGuide1();
        selectHome = KeylessUserGuide.skipDoneBtn1();
        //loginpage.search("30634");
        selectHome.taponSelectHome();
    }

}
