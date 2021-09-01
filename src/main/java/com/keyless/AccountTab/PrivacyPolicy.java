package com.keyless.AccountTab;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PrivacyPolicy extends BaseTest {

    @AndroidFindBy(accessibility = "ACCOUNT_TAB")
    @iOSXCUITFindBy(accessibility = "ACCOUNT_TAB")
    private MobileElement accountTab;

    @AndroidFindBy(accessibility = "privacyPolicy")
    @iOSXCUITFindBy(accessibility = "privacyPolicy")
    private MobileElement privacyPolicy;

    @AndroidFindBy(accessibility = "Rently")
    @iOSXCUITFindBy(accessibility = "Rently")
    private MobileElement Rently;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;


    public void tapOnAccountTab() {

        click(accountTab, "Tap on the Account Tab");

    }

    public void tapOnPrivacypolicy() {

        click(privacyPolicy, "Tap on the PrivacyPolicy");

    }


    public void checkForPrivacyPolicyMobileView() {

        waitForVisibility(Rently);

    }

    public void navigateBack() {

        click(homeBack, "Navigate back to Account Tab");

    }


}

