package com.keyless.AccountTab;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.ElementOption;

public class Support extends BaseTest {

    @AndroidFindBy(accessibility = "ACCOUNT_TAB")
    @iOSXCUITFindBy(accessibility = "ACCOUNT_TAB")
    private MobileElement accountTab;

    @AndroidFindBy(accessibility = "support")
    @iOSXCUITFindBy(accessibility = "support")
    private MobileElement support;

    @AndroidFindBy(accessibility = "help")
    @iOSXCUITFindBy(accessibility = "help")
    private MobileElement help;

    @AndroidFindBy(accessibility = "Rently Help Center home page")
    @iOSXCUITFindBy(accessibility = "Rently Help Center home page")
    private MobileElement rentlyHelpCenterHomePage;

    @AndroidFindBy(accessibility = "phoneSupport")
    @iOSXCUITFindBy(accessibility = "phoneSupport")
    private MobileElement phoneSupport;

    @AndroidFindBy(accessibility = "mailSupport")
    @iOSXCUITFindBy(accessibility = "mailSupport")
    private MobileElement mailSupport;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;


    public void tapOnAccountTab() {

        click(accountTab, "Tap on the Account Tab");

    }


    public void tapOnSupport() {

        click(support, "Tap on the support");
    }


    public void helpArticleSupport() {
        click(help, "Click on the support");
        waitForVisibility(rentlyHelpCenterHomePage);
        if(isIOS()){
            getDriver().activateApp("com.smart.rently");
        }else {
            getDriver().navigate().back();
        }
    }

    public void phoneSupport() throws InterruptedException {
        waitForVisibility(phoneSupport);
        new TouchAction<>(getDriver())
                .longPress(ElementOption.element(phoneSupport))
                .release()
                .perform();
        Thread.sleep(1000);
    }

    public void emailSupport() throws InterruptedException {
        waitForVisibility(mailSupport);
        new TouchAction<>(getDriver())
                .longPress(ElementOption.element(mailSupport))
                .release()
                .perform();
        Thread.sleep(1000);
    }

    public void navigateBack() {
        click(homeBack, "Navigate back to Account Tab");
    }


}

