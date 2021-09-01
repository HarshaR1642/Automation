package com.keyless.AccountTab;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ChangePassword extends BaseTest {

    @AndroidFindBy(accessibility = "ACCOUNT_TAB")
    @iOSXCUITFindBy(accessibility = "ACCOUNT_TAB")
    private MobileElement accountTab;

    @AndroidFindBy(accessibility = "changePassword")
    @iOSXCUITFindBy(accessibility = "changePassword")
    private MobileElement changePassword;

    @AndroidFindBy(accessibility = "oldPassword")
    @iOSXCUITFindBy(accessibility = "oldPassword")
    private MobileElement oldPassword;

    @AndroidFindBy(accessibility = "newPassword")
    @iOSXCUITFindBy(accessibility = "newPassword")
    private MobileElement newPassword;

    @AndroidFindBy(accessibility = "confirmPassword")
    @iOSXCUITFindBy(accessibility = "confirmPassword")
    private MobileElement confirmPassword;

    @AndroidFindBy(accessibility = "submit")
    @iOSXCUITFindBy(accessibility = "submit")
    private MobileElement submit;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private MobileElement texts;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Alert")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Incorrect old password")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Ok")
    private MobileElement alert;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement viewOldPassword;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement viewNewPassword;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement viewConfirmPassword;


    public MobileElement returnLastElement(MobileElement e,String accessibilityId){
        waitForVisibility(e);
        List<MobileElement> elements = getElements(accessibilityId, "accessibilityId");
        return elements.get(elements.size()-1);
    }

    public void tapOnAccountTab() {

        click(accountTab, "Tap on the Account Tab");
    }

    public void tapOnChangePassword() {

        click(changePassword, "Tap on the ChangePassword");
    }

    public void oldPassword(String password) {

        sendKeys(returnLastElement(oldPassword,"oldPassword"), password);
    }

    public void newPassword(String password) {

        sendKeys(returnLastElement(newPassword,"newPassword"), password);
    }

    public void confirmPassword(String password) {

        sendKeys(returnLastElement(confirmPassword,"confirmPassword"), password);
    }

    public void submit() {
        click(submit);
    }

    public void passwordsMustMatch() {

        SoftAssert sa = new SoftAssert();
        List<MobileElement> textElements = getElements("android.widget.TextView", "className");
        waitForVisibility(textElements.get(4));
        String text = getText(textElements.get(4), "");
        sa.assertEquals("• Passwords must match", text);
        sa.assertAll();

    }

    public String required(int index) {

        List<MobileElement> textElements = getElements("android.widget.TextView", "className");
        waitForVisibility(textElements.get(index));
        return getText(textElements.get(index), "");

    }

    public void requiredOldPassword() {

        SoftAssert sa = new SoftAssert();
        sa.assertEquals("• Required", required(2));
        sa.assertAll();

    }

    public void requiredNewPassword(int index) {

        SoftAssert sa = new SoftAssert();
        sa.assertEquals("• Required", required(index));
        sa.assertAll();

    }

    public void requiredConfirmPassword(int index) {

        SoftAssert sa = new SoftAssert();
        ;
        sa.assertEquals("• Required", required(index));
        sa.assertAll();

    }

    public void passwordCannotBeSameAsOldPassword() {

        SoftAssert sa = new SoftAssert();
        List<MobileElement> textElements = getElements("android.widget.TextView", "className");
        waitForVisibility(textElements.get(3));
        String text = getText(textElements.get(3), "");
        sa.assertEquals("• Password should not be the same as your old password", text);
        sa.assertAll();

    }

    public void passwordCharacters() {

        SoftAssert sa = new SoftAssert();
        List<MobileElement> textElements = getElements("android.widget.TextView", "className");
        waitForVisibility(textElements.get(3));
        String text = getText(textElements.get(3), "");
        sa.assertEquals("• Password must have at least 8 characters", text);
        sa.assertAll();

    }

    public String getOldPassword() {

        click(viewOldPassword);
        return getText(oldPassword, "");
    }

    public String getNewPassword() {

        click(viewNewPassword);
        return getText(newPassword, "");
    }

    public String getConfirmPassword() {

        click(viewConfirmPassword);
        return getText(confirmPassword, "");
    }

    public void checkAlertTitle() {

        SoftAssert sa = new SoftAssert();
        String title = getText(alertTitle, "Get the Alert Title");
        sa.assertEquals("Alert", title);
        sa.assertAll();

    }

    public void checkAlertMessageForInvalidOldPassword() {

        SoftAssert sa = new SoftAssert();
        String message = getText(alertMessage, "Get the Alert Message");
        sa.assertEquals("Incorrect old password", message);
        sa.assertAll();

    }

    public void checkAlertMessageForValidOldPassword() {

        SoftAssert sa = new SoftAssert();
        String message = getText(alertMessage, "Get the Alert Message");
        sa.assertEquals("Successfully Updated", message);
        sa.assertAll();

    }


    public void tapOnYes() {

        click(alert, "Tap on Yes");
        click(homeBack, "Navigate back to Account Tab");
    }


}

