package com.keyless.AccountTab;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class Logout extends BaseTest {

    @AndroidFindBy(accessibility = "ACCOUNT_TAB")
    @iOSXCUITFindBy(accessibility = "ACCOUNT_TAB")
    private MobileElement accountTab;

    @AndroidFindBy(accessibility = "logout")
    @iOSXCUITFindBy(accessibility = "logout")
    private MobileElement logout;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Logout")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Do you want to logout?")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alert;

    @AndroidFindBy(accessibility = "residentLogin")
    @iOSXCUITFindBy(accessibility = "residentLogin")
    private MobileElement residentLogin;


    public void tapOnAccountTab() {

        click(accountTab, "Tap on the Account Tab");

    }

    public void tapOnLogout() {

        click(logout, "Tap on the Logout");

    }

    public void checkAlertTitle() {

        SoftAssert sa = new SoftAssert();
        String title = getText(alertTitle, "Get the Alert Title");
        sa.assertEquals("Logout", title);
        sa.assertAll();

    }

    public void checkAlertMessage() {

        SoftAssert sa = new SoftAssert();
        String message = getText(alertMessage, "Get the Alert Message");
        sa.assertEquals("Do you want to logout?", message);
        sa.assertAll();

    }


    public void tapOnYesAndWaitForLoginScreen() {

        click(alert, "Tap on Yes");
        waitForVisibility(residentLogin);

    }


}

