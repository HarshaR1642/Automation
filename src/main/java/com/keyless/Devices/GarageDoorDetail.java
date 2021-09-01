package com.keyless.Devices;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class GarageDoorDetail extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.3);

    @AndroidFindBy(accessibility = "GarageDoorDetails")
    @iOSXCUITFindBy(accessibility = "GarageDoorDetails")
    private MobileElement garageDoorDetails;

    @AndroidFindBy(accessibility = "GarageDoorActivityTab")
    @iOSXCUITFindBy(accessibility = "GarageDoorActivityTab")
    private MobileElement garageDoorActivityTab;

    @AndroidFindBy(accessibility = "garageDoorCard")
    @iOSXCUITFindBy(accessibility = "garageDoorCard")
    private MobileElement garageDoorCard;

    @AndroidFindBy(accessibility = "OPENED")
    @iOSXCUITFindBy(accessibility = "OPENED")
    private MobileElement OPENED;

    @AndroidFindBy(accessibility = "CLOSED")
    @iOSXCUITFindBy(accessibility = "CLOSED")
    private MobileElement CLOSED;

    @AndroidFindBy(accessibility = "open")
    @iOSXCUITFindBy(accessibility = "open")
    private MobileElement openButton;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "close")
    private MobileElement closeButton;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private MobileElement texts;

    public void navigateToGarageDoor() {
        scrollToElement("garageDoorCard", "accessibilityId", startX, startY, endX, endY);
        clickOnDeviceCard(garageDoorCard, "Tap on garageDoorCard");
    }

    public void clickOnGarageDoorDetailsTab() {
        click(garageDoorDetails, "Tap on Garage Door Detail Tab");

    }

    public void clickOnGarageDoorActivityTab() {
        click(garageDoorActivityTab, "Tap on Activity Tab");

    }

    public String getState() {
        try {
            waitforvisbility(OPENED, 5);
            return "open";
        } catch (Exception e) {
            return "close";
        }

    }

    public String clickToClose() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(closeButton);
        Thread.sleep(2000);
        waitForVisibility(CLOSED);
        return systime;

    }

    public String clickToOpen() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(openButton);
        Thread.sleep(2000);
        waitForVisibility(OPENED);
        return systime;

    }

    public void checkActivity(String state, String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(texts);
        Thread.sleep(2000);
        String activity_status = getTextByIndex(1);
        if (state.equals("open")) {
            sa.assertEquals("Opened\nvia app", activity_status);
        } else {
            sa.assertEquals("Closed\nvia app", activity_status);
        }
        activity_status = getTextByIndex(2);
        sa.assertEquals(time, activity_status);
        sa.assertAll();
    }


}
