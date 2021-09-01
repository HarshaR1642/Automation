package com.keylessQE.test;

import com.keyless.pages.Lock_Dashboard;
import com.keylessQE.BaseTest;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class Lock_DashbaordTest extends BaseTest {

    JSONObject loginusers;
    Lock_Dashboard lockDashbrd;

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
        lockDashbrd = new Lock_Dashboard();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");


    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test(priority = 31)
    public void LockAsset() throws Exception {
        lockDashbrd.LockDevice();
        lockDashbrd.scroll(97, 1301, 625, 1449);
        SoftAssert sa = new SoftAssert();
        String lockStatus = lockDashbrd.lockStatus();
        sa.assertEquals(lockStatus, getStrings().get("Locked Status"));
        sa.assertAll();

    }

    @Test(priority = 32)
    public void UnLockAsset() throws Exception {
        lockDashbrd.UnLockDevice();
        lockDashbrd.scroll(679, 1301, 399, 1529);
        Thread.sleep(5000);
        SoftAssert sa = new SoftAssert();
        String UnlockStatus = lockDashbrd.unlockStatus();
        sa.assertEquals(UnlockStatus, getStrings().get("Unlocked Status"));
        sa.assertAll();

    }

}
