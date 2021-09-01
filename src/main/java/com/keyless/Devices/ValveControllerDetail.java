package com.keyless.Devices;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class ValveControllerDetail extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.7);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    @AndroidFindBy(accessibility = "ValveControllerDetails")
    @iOSXCUITFindBy(accessibility = "ValveControllerDetails")
    private MobileElement ValveControllerDetails;

    @AndroidFindBy(accessibility = "ValveControllerActivityTab")
    @iOSXCUITFindBy(accessibility = "ValveControllerActivityTab")
    private MobileElement ValveControllerActivityTab;

    @AndroidFindBy(accessibility = "valvecontrollerCard")
    @iOSXCUITFindBy(accessibility = "valvecontrollerCard")
    private MobileElement valvecontrollerCard;

    @iOSXCUITFindBy(accessibility = "valvecontrollerCard leakageSensorCard")
    private MobileElement valveControllerAndLeakageSensorCard;

    @AndroidFindBy(accessibility = "ON")
    @iOSXCUITFindBy(accessibility = "ON")
    private MobileElement ON;

    @AndroidFindBy(accessibility = "OFF")
    @iOSXCUITFindBy(accessibility = "OFF")
    private MobileElement OFF;

    @AndroidFindBy(accessibility = "on")
    @iOSXCUITFindBy(accessibility = "on")
    private MobileElement onButton;

    @AndroidFindBy(accessibility = "off")
    @iOSXCUITFindBy(accessibility = "off")
    private MobileElement offButton;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private MobileElement texts;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    public void navigateToValveController() {
        scrollToElement("valvecontrollerCard leakageSensorCard", "accessibilityId", startX, startY, endX, endY);
        clickOnDeviceCard(valveControllerAndLeakageSensorCard, "Tap on valvecontrollerCard");
    }

    public void navigateBack() {

        click(homeBack, "Navigate back to Dashboard");

    }

    public ValveControllerDetail clickOnValveControllerDetailsTab() {
        click(ValveControllerDetails, "Tap on Lock Detail Tab");
        return this;

    }

    public void clickOnValveControllerActivityTab() {
        click(ValveControllerActivityTab, "Tap on Activity Tab");

    }

    public String getState() {
        try {
            waitforvisbility(ON, 5);
            return "on";
        } catch (Exception e) {
            return "off";
        }

    }

    public String clickToOff() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(offButton);
        Thread.sleep(2000);
        waitForVisibility(OFF);
        return systime;

    }

    public String clickToOn() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(onButton);
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
