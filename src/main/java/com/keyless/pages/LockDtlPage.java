package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LockDtlPage extends BaseTest {


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='lockDetails']/android.view.ViewGroup")
    private MobileElement enter_LockDtlpage;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='unlockIcon'])[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement Unlock_btn;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='LOCKED'])/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement locked;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='UNLOCKED'])/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement unlocked;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='lockIcon'])[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement lock_btn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='LocksActivityTab']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement lock_Activity;

    @AndroidFindBy(xpath = "//android.Text.View")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement texts;

//	public void tapondtlpgeBtn()
//	{
//		click(enter_LockDtlpage,"Tap on Lock detail page button");
//		return this;
//     }

    public LockDtlPage tapondtlpgeBtn() {
        click(enter_LockDtlpage, "Tap on Lock detail page button");
        return this;

    }

    public String getState() {
        try {
            waitforvisbility(locked, 5);
            return "lock";
        } catch (Exception e) {
            return "unlock";
        }

    }

    public String SwipeToUnlock() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        new TouchAction((PerformsTouchActions) getDriver())
                .press(ElementOption.element(Unlock_btn))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(lock_btn))
                .release()
                .perform();
        Thread.sleep(2000);
        waitForVisibility(unlocked);
        return systime;

    }

    public String SwipeToLock() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        new TouchAction((PerformsTouchActions) getDriver())
                .press(ElementOption.element(lock_btn))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(Unlock_btn))
                .release()
                .perform();
        Thread.sleep(2000);
        waitForVisibility(locked);
        return systime;

    }

    public LockDtlPage checkActivity(String state, String time) {
        SoftAssert sa = new SoftAssert();
        click(lock_Activity, "Tap Activity tab.");
        waitForVisibility(texts);
        swipeVertical(null);
        waitForVisibility(texts);
        String activity_status = getTextByIndex(1);
        if (state == "lock") {
            sa.assertEquals("Locked \nvia app", activity_status);
        } else {
            sa.assertEquals("Unlocked \nvia app", activity_status);
        }
        activity_status = getTextByIndex(2);
        sa.assertEquals(time, activity_status);
        click(enter_LockDtlpage, "Tap on Details Tab");
        return this;
    }


}
