package com.keylessQE.test.AccountTab;

import com.keyless.AccountTab.UserGuide;
import com.keyless.pages.Login_Keyless;
import com.keyless.utils.testUtils;
import com.keylessQE.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class UserGuideTest extends BaseTest {
    static AppiumDriver driver;
    Login_Keyless loginpage;
    BaseTest Base_Test;
    UserGuide KeylessUserGuide;
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
        KeylessUserGuide = new UserGuide();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @AfterMethod
    public void afterMethod() {
    }


    @Test(priority = 11)
    public void tapSkipBtn() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        KeylessUserGuide.skipUsrGuide();
        String SkipPopDescription = KeylessUserGuide.SkipPopDescp();
        sa.assertEquals(SkipPopDescription, getStrings().get("SkipBtnDescription"));
        sa.assertAll();
        KeylessUserGuide.skipDoneBtn();
        Thread.sleep(5000);
        closeApp();
        launchApp();
        Thread.sleep(5000);
        loginpage = new Login_Keyless();
        KeylessUserGuide = loginpage.taponLoginAsResident2();
        KeylessUserGuide = loginpage.login(loginusers.getJSONObject("valid_usrId_pswd").getString("username"),
                loginusers.getJSONObject("valid_usrId_pswd").getString("password"));
        Thread.sleep(3000);
        //  loginpage.taponLoginBtn();
    }

    @Test(priority = 5)
    public void tapNxtBtn() {

        SoftAssert sa = new SoftAssert();
        String fstpagetitle = KeylessUserGuide.UG1stTitle();
        sa.assertEquals(fstpagetitle, getStrings().get("firstpage_title"));
        String fstpagedescrption = KeylessUserGuide.UG1stDescription();
        sa.assertEquals(fstpagedescrption, getStrings().get("firstpage_Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();

    }


    @Test(priority = 6)
    public void UG2() {
        SoftAssert sa = new SoftAssert();
        String scndpagetitle = KeylessUserGuide.UG2ndTitle();
        sa.assertEquals(scndpagetitle, getStrings().get("2nd Page Title"));
        String scndpagedescrption = KeylessUserGuide.UG12ndDescription();
        sa.assertEquals(scndpagedescrption, getStrings().get("2nd Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();

    }

    @Test(priority = 7)
    public void UG3() {
        SoftAssert sa = new SoftAssert();
        String Trdpagetitle = KeylessUserGuide.UG3rdTitle();
        sa.assertEquals(Trdpagetitle, getStrings().get("3rd Page Title"));
        String thrdpagedescrption = KeylessUserGuide.UG13rdDescription();
        sa.assertEquals(thrdpagedescrption, getStrings().get("3rd Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();

    }

    @Test(priority = 8)
    public void UG4() {
        SoftAssert sa = new SoftAssert();
        String frthpagetitle = KeylessUserGuide.UG4thTitle();
        sa.assertEquals(frthpagetitle, getStrings().get("4th Page Title"));
        String frthpagedescrption = KeylessUserGuide.UG14thDescription();
        sa.assertEquals(frthpagedescrption, getStrings().get("4th Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();
    }

    @Test(priority = 9)
    public void UG5() {
        SoftAssert sa = new SoftAssert();
        String frthpagetitle = KeylessUserGuide.UG5thTitle();
        sa.assertEquals(frthpagetitle, getStrings().get("5th Page Title"));
        String ffthpagedescrption = KeylessUserGuide.UG15thDescription();
        sa.assertEquals(ffthpagedescrption, getStrings().get("5th Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();
    }

    @Test(priority = 10)
    public void UG6() {
        SoftAssert sa = new SoftAssert();
        String sxthpagetitle = KeylessUserGuide.UG6thTitle();
        sa.assertEquals(sxthpagetitle, getStrings().get("6th Page Title"));
        String sxthpagedescrption = KeylessUserGuide.UG16thDescription();
        sa.assertEquals(sxthpagedescrption, getStrings().get("6th Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();
    }


    @Test(priority = 11)
    public void UG7() {
        SoftAssert sa = new SoftAssert();
        String svnthpagetitle = KeylessUserGuide.UG7thTitle();
        sa.assertEquals(svnthpagetitle, getStrings().get("7th Page Title"));
        String svnthpagedescrption = KeylessUserGuide.UG17thDescription();
        sa.assertEquals(svnthpagedescrption, getStrings().get("7th Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();
    }

    @Test(priority = 12)
    public void UG8() {
        SoftAssert sa = new SoftAssert();
        String eghtnthpagetitle = KeylessUserGuide.UG8thTitle();
        sa.assertEquals(eghtnthpagetitle, getStrings().get("8th Page Title"));
        String egthpagedescrption = KeylessUserGuide.UG18thDescription();
        sa.assertEquals(egthpagedescrption, getStrings().get("8th Page Description"));
        sa.assertAll();
        KeylessUserGuide.tapNext();
    }

    @Test(priority = 13)
    public void UG9() {
        SoftAssert sa = new SoftAssert();
        String nintnthpagetitle = KeylessUserGuide.UG9thTitle();
        sa.assertEquals(nintnthpagetitle, getStrings().get("9th Page Title"));
        String ninthpagedescrption = KeylessUserGuide.UG19thDescription();
        sa.assertEquals(ninthpagedescrption, getStrings().get("9th Page Description"));
        sa.assertAll();
    }


    @Test(priority = 14)
    public void UGDone() {
        KeylessUserGuide.tapDone();

    }


    @Test(priority = 15)
    public void UGDonePopup() {
        SoftAssert sa = new SoftAssert();
        String Donetext = KeylessUserGuide.DoneTxt();
        sa.assertEquals(Donetext, getStrings().get("Succefull Done"));
        sa.assertAll();

    }

    @Test(priority = 16)
    public void UGDoneClosePopup() throws Exception {
        KeylessUserGuide.DonePopupClose();
        Thread.sleep(5000);
    }


}
