package com.keyless.Devices;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class Siren extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    @AndroidFindBy(accessibility = "SirenDetails")
    @iOSXCUITFindBy(accessibility = "SirenDetails")
    private MobileElement SirenDetails;

    @AndroidFindBy(accessibility = "SirenActivityTab")
    @iOSXCUITFindBy(accessibility = "SirenActivityTab")
    private MobileElement SirenActivityTab;

    @AndroidFindBy(accessibility = "sirenCard")
    @iOSXCUITFindBy(accessibility = "sirenCard")
    private MobileElement sirenCard;

    @AndroidFindBy(accessibility = "ON")
    @iOSXCUITFindBy(accessibility = "ON")
    private MobileElement ON;

    @AndroidFindBy(accessibility = "OFF")
    @iOSXCUITFindBy(accessibility = "OFF")
    private MobileElement OFF;

    @AndroidFindBy(accessibility = "test")
    @iOSXCUITFindBy(accessibility = "test")
    private MobileElement test;

    @AndroidFindBy(accessibility = "stop")
    @iOSXCUITFindBy(accessibility = "stop")
    private MobileElement stop;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private MobileElement texts;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Test Siren")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Do you want to hear the Siren ringing ?")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alert;

    public void navigateToSirenDevice() {
        scrollToElement("sirenCard", "accessibilityId", startX, startY, endX, endY);
        clickOnDeviceCard(sirenCard, "Tap on sirenCard");
    }

    public void navigateBack() {

        click(homeBack, "Navigate back to Dashboard");

    }

    public Siren clickOnSirenDetailsTab() {
        click(SirenDetails, "Tap on Siren Detail Tab");
        return this;

    }

    public void clickOnSirenActivityTab() {
        click(SirenActivityTab, "Tap on Activity Tab");

    }

    public void checkAlertTitle() {

        SoftAssert sa = new SoftAssert();
        String title = getText(alertTitle, "Get the Alert Title");
        sa.assertEquals("Test Siren", title);
        sa.assertAll();

    }

    public void checkAlertMessage() {

        SoftAssert sa = new SoftAssert();
        String message = getText(alertMessage, "Get the Alert Message");
        sa.assertEquals("Do you want to hear the Siren ringing ?", message);
        sa.assertAll();

    }


    public void handleAlert() {

        click(alert, "Tap on Yes");

    }

    public String getState() {
        try {
            waitforvisbility(ON, 5);
            return "on";
        } catch (Exception e) {
            return "off";
        }

    }

    public String clickToStop() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(stop);
        Thread.sleep(2000);
        waitForVisibility(OFF);
        return systime;

    }

    public String clickToTest() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(test);
        checkAlertTitle();
        checkAlertMessage();
        handleAlert();
        Thread.sleep(2000);
        waitForVisibility(ON);
        return systime;

    }

    public void checkActivity(String state, String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(texts);
        Thread.sleep(2000);
        String activity_status = getTextByIndex(1);
        if (state.equals("on")) {
            sa.assertEquals("On\nvia app", activity_status);
        } else {
            sa.assertEquals("Off\nvia app", activity_status);
        }
        activity_status = getTextByIndex(2);
        sa.assertEquals(time, activity_status);
    }


}
