package com.keylessQE.test.AccountTab;

import com.keyless.AccountTab.ChangePassword;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ChangePasswordTest {

    JSONObject loginusers;
    ChangePassword changePassword;

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
        changePassword = new ChangePassword();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void changePasswordTest() throws Exception {
        changePassword.tapOnAccountTab();
        changePassword.tapOnChangePassword();
        changePassword.oldPassword("Rakesh888");
        changePassword.newPassword("Rakesh88");
        changePassword.confirmPassword("Rakesh88");
        changePassword.submit();
        changePassword.tapOnYes();
    }

}
