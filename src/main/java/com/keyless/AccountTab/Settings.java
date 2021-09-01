package com.keyless.AccountTab;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class Settings extends BaseTest {

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
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement TapOnYes;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;


    public void tapOnAccountTab() {

        click(accountTab, "Tap on Account Tab");

    }

    public void tapOnSettings() {

        click(settings, "Tap on Settings");

    }

    public void toggleSettings(MobileElement e) {

        SoftAssert sa = new SoftAssert();
        waitForVisibility(e);
        String currentState = getText(e, "State before tapping");
        System.out.println("currentState : " + currentState);
        click(e);
        waitForVisibility(e);
        String newState = getText(e, "getting state after tapping ");
        System.out.println("State after tapping : " + newState);
        sa.assertNotEquals(currentState, newState);
        if(!isIOS()){
            sa.assertAll();
        }

    }

    public void toggleEmail() {

        toggleSettings(emailAlerts);

    }

    public void togglePushNotification() {
        try {
            if (pushNotification.isDisplayed()) {
                toggleSettings(pushNotification);
            }
        } catch (Exception ignored) {
        }

    }

    public void toggleRoutines() {
        try {
            if (routines.isDisplayed()) {
                toggleSettings(routines);
            }
        }catch (Exception ignored) {
        }

    }

    public void toggleNotifyAllUnlock() {
        try {
            if (notifyAllUnlock.isDisplayed()) {
                toggleSettings(notifyAllUnlock);
            }
        }catch (Exception ignored) {
        }
    }

    public void toggleNotifyContactSensor() {
        try {
            if (notifyContactSensor.isDisplayed()) {
                toggleSettings(notifyContactSensor);
            }
        }catch (Exception ignored) {
        }
    }

    public void toggleFaceID() {
        try {
            if (faceID.isDisplayed()) {
                toggleSettings(faceID);
            }
        }catch (Exception ignored) {
        }
    }

    public void navigateBack() {

        click(homeBack, "Navigate back to Account Tab");

    }

}
