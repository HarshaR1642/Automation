package com.keyless.Devices;
import com.aventstack.extentreports.Status;
import com.keyless.utils.testUtils;
import com.keylessQE.BaseTest;
import com.qe_Keyless.reports.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.asserts.SoftAssert;

public class LockDetail extends BaseTest {

    testUtils utils = new testUtils();

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    @AndroidFindBy(accessibility = "LockDetailsTab")
    @iOSXCUITFindBy(accessibility = "LockDetailsTab")
    private MobileElement lockDetailsTab;

    @AndroidFindBy(accessibility = "unlockIcon")
    @iOSXCUITFindBy(accessibility = "unlockIcon")
    private MobileElement unlockButton;

    @AndroidFindBy(accessibility = "LOCKED")
    @iOSXCUITFindBy(accessibility = "LOCKED")
    private MobileElement locked;

    @AndroidFindBy(accessibility = "UNLOCKED")
    @iOSXCUITFindBy(accessibility = "UNLOCKED")
    private MobileElement unlocked;

    @AndroidFindBy(accessibility = "lockIcon")
    @iOSXCUITFindBy(accessibility = "lockIcon")
    private MobileElement lockButton;

    @AndroidFindBy(accessibility = "LocksActivityTab")
    @iOSXCUITFindBy(accessibility = "LocksActivityTab")
    private MobileElement lockActivityTab;

    @AndroidFindBy(accessibility = "locksCard")
    @iOSXCUITFindBy(accessibility = "locksCard")
    private MobileElement locksCard;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private MobileElement texts;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    public void navigateToLock() {
        scrollToElement("locksCard", "accessibilityId", startX, startY, endX, endY);
        clickOnDeviceCard(locksCard, "Tap on Locks Card");
    }

    public void navigateBack() {

        click(homeBack, "Navigate back to Dashboard");

    }

    public LockDetail clickOnLockDetailsTab() {
        click(lockDetailsTab, "Tap on Lock Detail Tab");
        return this;

    }

    public void clickOnLockActivityTab() {
        click(lockActivityTab, "Tap on Activity Tab");

    }

    public String getState() {
        try {
            waitforvisbility(locked, 5);
            return "lock";
        } catch (Exception e) {
            return "unlock";
        }

    }

    public void swipe(MobileElement press,MobileElement moveTo, String beforeSwipe, String afterSwipe) throws Exception {
        utils.log().info(beforeSwipe);
        ExtentReport.getTest().log(Status.INFO, beforeSwipe);
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(ElementOption.element(press))
                .moveTo(ElementOption.element(moveTo))
                .release()
                .perform();
        utils.log().info(afterSwipe);
        ExtentReport.getTest().log(Status.INFO, afterSwipe);
    }

    public String SwipeToUnlock() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        swipe(unlockButton,lockButton,"Unlocking...","Unlock Successfull");
        Thread.sleep(2000);
        waitForVisibility(unlocked);
        return systime;

    }

    public String SwipeToLock() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        swipe(lockButton,unlockButton,"Locking...","Lock Successfull");
        Thread.sleep(2000);
        waitForVisibility(locked);
        return systime;

    }

    public void checkActivity(String state, String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(texts);
        Thread.sleep(2000);
        String activity_status = getTextByIndex(1);
        if (state.equals("lock")) {
            sa.assertEquals("Locked\nvia app", activity_status);
        } else {
            sa.assertEquals("Unlocked\nvia app", activity_status);
        }
        activity_status = getTextByIndex(2);
        sa.assertEquals(time, activity_status);
    }


}
