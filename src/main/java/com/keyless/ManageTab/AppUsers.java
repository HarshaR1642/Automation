package com.keyless.ManageTab;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class AppUsers extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    @AndroidFindBy(accessibility = "MANAGE_TAB")
    @iOSXCUITFindBy(accessibility = "MANAGE_TAB")
    private MobileElement manageTab;

    @AndroidFindBy(accessibility = "appUsers")
    @iOSXCUITFindBy(accessibility = "appUsers")
    private MobileElement appUsers;

    @AndroidFindBy(accessibility = "email")
    @iOSXCUITFindBy(accessibility = "email")
    private MobileElement email;

    @AndroidFindBy(accessibility = "invite")
    @iOSXCUITFindBy(accessibility = "invite")
    private MobileElement invite;

    @AndroidFindBy(accessibility = "EMAIL")
    @iOSXCUITFindBy(accessibility = "EMAIL")
    private MobileElement invitedEmail;

    @AndroidFindBy(accessibility = "HOME")
    @iOSXCUITFindBy(accessibility = "HOME")
    private MobileElement home;

    @AndroidFindBy(accessibility = "TYPE")
    @iOSXCUITFindBy(accessibility = "TYPE")
    private MobileElement type;

    @AndroidFindBy(accessibility = "STATUS")
    @iOSXCUITFindBy(accessibility = "STATUS")
    private MobileElement status;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alert;

    public void clickOnManageTab() {
        click(manageTab, "Tap on the Manage Tab");
    }

    public void clickOnAppUsers() {
        click(appUsers, "Tap on App Users");
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void inviteUser(String mailId) {
        sendKeys(email, mailId, "Inviting " + mailId);
        click(invite, "Tap on invite button");
        waitForVisibility(invite);
    }

    public void inviteUserWithForeverAccess(String mailId) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        sendKeys(email, mailId, "Inviting " + mailId);
        click(invite, "Tap on invite button");
        Thread.sleep(2000);
        List<MobileElement> elements = getElements("android:id/button1", "id");
        if (elements.size() != 0) {
            sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Alert");
            sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Occupant Already Invited");
            click(alert, "Tap on 'ok'");
            waitForVisibility(invite);
            deleteUser(mailId);
            inviteUser(mailId);
        }
        waitForVisibility(invite);

        sa.assertAll();

    }

    public void inviteExistingUser(String mailId) {
        SoftAssert sa = new SoftAssert();
        sendKeys(email, mailId, "Inviting " + mailId);
        click(invite, "Tap on invite button");
        sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Alert");
        sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Occupant Already Invited");
        click(alert, "Tap on 'ok'");
        waitForVisibility(invite);
        sa.assertAll();

    }

    public boolean checkInvitedEmail(String mailID) throws InterruptedException {
        waitForVisibility(invite);
        List<MobileElement> emails = getElements("EMAIL", "accessibilityId");
        while (true) {
            if (emails.size() == 0) {
                scroll(startX, startY, endX, endY);
                Thread.sleep(1000);
                emails = getElements("EMAIL", "accessibilityId");
            } else {
                for (MobileElement mobileElement : emails) {
                    String mail = getText(mobileElement, "Get EmailID ");
                    if (mail.equals(mailID)) {
                        return true;
                    }
                }
                scroll(startX, startY, endX, endY);
                Thread.sleep(2000);
                emails = getElements("EMAIL", "accessibilityId");
            }
        }
    }

    public void deleteUser(String mailId) {
        SoftAssert sa = new SoftAssert();
        String id = "delete".concat(mailId);
        scrollToElement(id, "accessibilityId", startX, startY, endX, endY);
        List<MobileElement> deleteUsers = getElements(id, "accessibilityId");
        MobileElement deleteUser = deleteUsers.get(0);
        click(deleteUser);
        sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Delete Access");
        sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Are you sure you want to remove access?");
        click(alert, "Tap on 'ok'");
        waitForVisibility(invite);
        sa.assertAll();

    }


    public void checkInvitedMailIdInAppUsers(String mailId) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(checkInvitedEmail(mailId));
        sa.assertAll();
    }

}
	
	
	
	
	
	
	

