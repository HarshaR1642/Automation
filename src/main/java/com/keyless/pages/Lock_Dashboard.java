package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Lock_Dashboard extends BaseTest {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='lockIcon']/android.view.ViewGroup")
    private MobileElement LockBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='unlockIcon']/android.view.ViewGroup")
    private MobileElement UnlockBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='default']")
    private MobileElement UnknwnStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='locked']")
    private MobileElement LockedStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='unlocked']")
    private MobileElement unlockStatus;

    public Lock_Dashboard LockDevice() {
        swipeRight(LockBtn);
        return this;
    }

    public Lock_Dashboard UnLockDevice() {
        swipeLeft(UnlockBtn);
        return this;
    }

    public String lockStatus() {
        String description = getText(LockedStatus, "status after lock-");
        System.out.println("After lock the status found on the dashboard -" + description);
        return description;
    }

    public String unlockStatus() {
        String description = getText(unlockStatus, "status after unlock-");
        System.out.println("After unlock the status found on the dashboard -" + description);
        return unlockStatus();
    }

    public String unknownStatus() {
        String description = getText(UnknwnStatus, "status if the lock is jam-");
        System.out.println("After lock the status found on the dashboard -" + description);
        return description;
    }


}
