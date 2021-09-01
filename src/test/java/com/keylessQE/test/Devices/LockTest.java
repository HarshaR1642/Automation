package com.keylessQE.test.Devices;

import com.keyless.Devices.LockDetail;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.lang.reflect.Method;

public class LockTest {

    JSONObject loginusers;
    LockDetail lockDetail;

    @BeforeClass
    public void beforeClass() throws Exception {

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
        lockDetail = new LockDetail();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void lockTest1() throws Exception {
        Thread.sleep(1000);
        lockDetail.navigateToLock();
        String time = null;
        if (lockDetail.getState().equals("lock")) {
            time = lockDetail.SwipeToUnlock();
            lockDetail.clickOnLockActivityTab();
            lockDetail.checkActivity("unlock", time);
            lockDetail.clickOnLockDetailsTab();
        } else {
            time = lockDetail.SwipeToLock();
            lockDetail.clickOnLockActivityTab();
            lockDetail.checkActivity("lock", time);
            lockDetail.clickOnLockDetailsTab();
        }
    }


    @Test
    public void lockTest2() throws Exception {
        Thread.sleep(1000);
        String time = null;
        if (lockDetail.getState().equals("lock")) {
            time = lockDetail.SwipeToUnlock();
            lockDetail.clickOnLockActivityTab();
            lockDetail.checkActivity("unlock", time);
            lockDetail.clickOnLockDetailsTab();
            lockDetail.navigateBack();
        } else {
            time = lockDetail.SwipeToLock();
            lockDetail.clickOnLockActivityTab();
            lockDetail.checkActivity("lock", time);
            lockDetail.clickOnLockDetailsTab();
            lockDetail.navigateBack();

        }
    }


}

