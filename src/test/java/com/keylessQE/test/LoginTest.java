package com.keylessQE.test;

import com.keyless.AccountTab.UserGuide;
import com.keyless.pages.Login_Keyless;
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

public class LoginTest extends BaseTest {

    static AppiumDriver driver;
    Login_Keyless loginpage;
    UserGuide UGpage;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

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
        loginpage = new Login_Keyless();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }


//  @Test(priority=0)
//  public void Succsfull_Login() throws Exception
//  {
//	 
//	  Thread.sleep(3000);
//	  
//	 
//	loginpage.taponLoginAsResident();
//	  loginpage.enterEmail(loginusers.getJSONObject("valid_usrId_pswd").getString("username"));
//	  loginpage.enterpassword(loginusers.getJSONObject("valid_usrId_pswd").getString("password"));
//	  loginpage.tapoutsides();
//	  UGpage = loginpage.taponLoginBtn(); 
//	  
//	  
//  }

    @Test(priority = 56)
    public void managerLogin() throws Exception {
        loginpage = new Login_Keyless();
        loginpage.taponLoginAsManager();
        loginpage.login_1(loginusers.getJSONObject("valid_usrId_pswd_manager").getString("username"),
                loginusers.getJSONObject("valid_usrId_pswd_manager").getString("password"));

    }


}
