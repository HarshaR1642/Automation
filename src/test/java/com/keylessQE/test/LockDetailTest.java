package com.keylessQE.test;

import com.keyless.pages.LockDtlPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class LockDetailTest {

    JSONObject loginusers;
    LockDtlPage lockDtlpge;

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
        lockDtlpge = new LockDtlPage();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test(priority = 36)
    public void lockUnlock() throws Exception {
        lockDtlpge.tapondtlpgeBtn();
        String time = null;
        if (lockDtlpge.getState().equals("lock")) {
            time = lockDtlpge.SwipeToUnlock();
            lockDtlpge.checkActivity("unlock", time);
        } else {
            time = lockDtlpge.SwipeToLock();
            lockDtlpge.checkActivity("lock", time);
        }


    }


}
