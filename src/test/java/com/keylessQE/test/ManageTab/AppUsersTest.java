package com.keylessQE.test.ManageTab;

import com.keyless.ManageTab.AppUsers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class AppUsersTest {

    JSONObject loginusers;
    AppUsers appUsers;

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
        appUsers = new AppUsers();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test(priority = 51)
    public void inviteAppUsersTest1() throws Exception {
        appUsers.clickOnManageTab();
        appUsers.clickOnAppUsers();
        appUsers.inviteUserWithForeverAccess("automation@mailinator.com");
    }

    @Test(priority = 52)
    public void inviteExistingUserTest() throws Exception {
        appUsers.inviteExistingUser("automation@mailinator.com");
    }

    @Test(priority = 53)
    public void deleteAppUsersTest() throws Exception {
        appUsers.checkInvitedMailIdInAppUsers("automation@mailinator.com");
        appUsers.deleteUser("automation@mailinator.com");
    }

    @Test(priority = 54)
    public void inviteAppUsersTest2() throws Exception {
        try {
            appUsers.inviteUser("automation@mailinator.com");
            appUsers.navigateBack();
        }catch (Exception e){
            appUsers.navigateBack();
        }
    }


}

