package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class Account_tab extends BaseTest {

    @AndroidFindBy(accessibility = "logout")
    @iOSXCUITFindBy(accessibility = "logout")
    private MobileElement TapOnlogout;

    @AndroidFindBy(accessibility = "ACCOUNT_TAB")
    @iOSXCUITFindBy(accessibility = "ACCOUNT_TAB")
    private MobileElement accountTab;

    @AndroidFindBy(accessibility = "settings")
    @iOSXCUITFindBy(accessibility = "settings")
    private MobileElement settings;

    @AndroidFindBy(accessibility = "emailAlerts")
    @iOSXCUITFindBy(accessibility = "emailAlerts")
    private MobileElement emailAlerts;

    @AndroidFindBy(accessibility = "pushNotification")
    @iOSXCUITFindBy(accessibility = "pushNotification")
    private MobileElement pushNotification;

    @AndroidFindBy(accessibility = "notifyAllUnlock")
    @iOSXCUITFindBy(accessibility = "notifyAllUnlock")
    private MobileElement notifyAllUnlock;

    @AndroidFindBy(accessibility = "routines")
    @iOSXCUITFindBy(accessibility = "routines")
    private MobileElement routines;

    @AndroidFindBy(accessibility = "notifyContactSensor")
    @iOSXCUITFindBy(accessibility = "notifyContactSensor")
    private MobileElement notifyContactSensor;

    @AndroidFindBy(accessibility = "faceID")
    @iOSXCUITFindBy(accessibility = "faceID")
    private MobileElement faceID;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement TapOnYes;

    public Login_Keyless logout() {
        click(TapOnlogout);
        return new Login_Keyless();
    }

    public Login_Keyless clickOnSettings() {
        click(settings);
        return new Login_Keyless();
    }


    public Login_Keyless logoutYes() {
        click(TapOnYes);
        return new Login_Keyless();
    }

    public void clickOnAccountTab() {
        click(accountTab);
    }

    public void toggleSettings(MobileElement e) {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(e);
        String currrentState = getText(e, "State of the " + e);
        System.out.println("currentState : " + currrentState);
        click(e, "tap on " + e);
        waitForVisibility(e);
        String newState = getText(e, "getting state after tapping ");
        System.out.println("State after tapping : " + newState);
        sa.assertNotEquals(currrentState, newState);
        sa.assertAll();
    }

    public void toggleEmail() {
        toggleSettings(emailAlerts);
    }

    public void togglePushNotification() {
        toggleSettings(pushNotification);
    }

    public void toggleRoutines() {
        toggleSettings(routines);
    }

    public void toggleNotifyAllUnlock() {
        toggleSettings(notifyAllUnlock);
    }

    public void toggleNotifyContactSensor() {
        toggleSettings(notifyContactSensor);
    }

    public void toggleFaceID() {
        toggleSettings(faceID);
    }

}
