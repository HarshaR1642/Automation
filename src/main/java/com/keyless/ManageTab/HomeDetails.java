package com.keyless.ManageTab;
import com.keyless.AccountTab.Logout;
import com.keyless.pages.Select_Home;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class HomeDetails extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.2);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.6);

    @AndroidFindBy(accessibility = "residentHome0")
    @iOSXCUITFindBy(accessibility = "residentHome0")
    private MobileElement residentHome;

    @AndroidFindBy(accessibility = "managerHome")
    @iOSXCUITFindBy(accessibility = "managerHome")
    private MobileElement managerHome;

    @AndroidFindBy(accessibility = "MANAGE_TAB")
    @iOSXCUITFindBy(accessibility = "MANAGE_TAB")
    private MobileElement manageTab;

    @AndroidFindBy(accessibility = "homeDetails")
    @iOSXCUITFindBy(accessibility = "homeDetails")
    private MobileElement homeDetails;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ADDRESS\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private MobileElement nestedAddressField;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement textView;

    @AndroidFindBy(accessibility = "homeName")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"homeName\"]")
    private MobileElement homeName;

    @AndroidFindBy(accessibility = "city")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"city\"]")
    private MobileElement city;

    @AndroidFindBy(accessibility = "state")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"state\"]")
    private MobileElement state;

    @AndroidFindBy(accessibility = "zipCode")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"zipCode\"]")
    private MobileElement zipCode;

    @AndroidFindBy(accessibility = "latitude")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"latitude\"]")
    private MobileElement latitude;

    @AndroidFindBy(accessibility = "longitude")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"longitude\"]")
    private MobileElement longitude;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alert;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    @AndroidFindBy(accessibility = "HOME_TAB")
    @iOSXCUITFindBy(accessibility = "HOME_TAB")
    private MobileElement homeTab;

    @AndroidFindBy(accessibility = "selectHome")
    @iOSXCUITFindBy(accessibility = "selectHome")
    private MobileElement selectHome;

    private String savedHomeName = null;
    private String savedAddress = null;
    private boolean isSaved = false;

    public Logout clickOnManageTab() {
        click(manageTab, "Click on the Manage Tab");
        return new Logout();
    }

    public Logout clickOnHomeDetails() {
        click(homeDetails, "Click on the Account Tab");
        return new Logout();
    }

    public Select_Home homeDetails() {
        return new Select_Home();
    }

    public void scrollToElement(String element) {
        while (getElements(element, "accessibilityId").size() == 0) {
            scroll(500, 600, 500, 100);

        }
    }

    public void updateHomeName(String name) {
        waitForVisibility(homeName);
        sendKeys(homeName, name);
        savedHomeName = name;

    }

    public void updateAddress(String address) {
        List<MobileElement> editFields = getElements("android.widget.EditText", "className");
        editFields.get(1).clear();
        editFields.get(1).sendKeys(address);
        savedAddress = address;
    }

    public void updateCity(String cityName) throws InterruptedException {
        Thread.sleep(1000);
        sendKeys(city, cityName);

    }

    public void updateState(String stateName) throws InterruptedException {
        Thread.sleep(1000);
        sendKeys(state, stateName);

    }

    public void updateZipCode(String zipCodeNumber) throws InterruptedException {
        scrollToElement("zipCode");
        Thread.sleep(1000);
        sendKeys(zipCode, zipCodeNumber);

    }

    public void updateLatitude(String latit) throws InterruptedException {
        scrollToElement("latitude");
        Thread.sleep(1000);
        sendKeys(latitude, latit);

    }

    public void updateLongitude(String longit) throws InterruptedException {
        scrollToElement("longitude");
        Thread.sleep(1000);
        sendKeys(longitude, longit);

    }

    public void save() throws InterruptedException {
        scrollToElement("save");
        Thread.sleep(1000);
        click(save, "Click on Save Button");
    }

    public void checkAlertTitle() {
        SoftAssert sa = new SoftAssert();
        String title = getText(alertTitle, "Get Alert Title");
        System.out.println("Title :" + title);
        sa.assertEquals("Success", title);
        sa.assertAll();

    }

    public void checkAlertMessage() {
        SoftAssert sa = new SoftAssert();
        String message = getText(alertMessage, "Get Alert Message");
        System.out.println("message :" + message);
        sa.assertEquals("Successfully updated.", message);
        sa.assertAll();
    }

    public void clickOk() {
        click(alert, "Click Ok");
        isSaved = true;
    }

    public void navigateBack() {
        click(homeBack, "Navigate back to Account Tab");
    }

    public void clickOnHomeTab() {
        click(homeTab, "Click On Home Tab");
    }

    public void checkHomeNameInDashboard() {
        try {
            if (isSaved) {
                SoftAssert sa = new SoftAssert();
                Thread.sleep(1200);
                scrollToElement("selectHome", "accessibilityId", startX, startY, endX, endY);
                scroll(startX, startY, endX, endY);
                waitForVisibility(selectHome);
                waitForVisibility(textView);
                List<MobileElement> texts = getElements("android.widget.TextView", "className");
                String homeNameInDashboard = getText(texts.get(0), "Get Home Name From Dashboard");
                System.out.println("HomeName :" + homeNameInDashboard);
                sa.assertEquals(savedHomeName, homeNameInDashboard);
                sa.assertAll();
            }
        }catch (Exception ignored){
        }

    }

    public void clickOnSelectHome() {
        click(selectHome, "Click On Select Home");
    }

    public void checkAddress() {
        if (isSaved) {
            SoftAssert sa = new SoftAssert();
            waitForVisibility(residentHome);
            List<MobileElement> texts = getElements("android.widget.TextView", "className");
            for (int element = 0; element < texts.size(); element++) {
                if (savedHomeName.equals(getText(texts.get(0), ""))) {
                    try {
                        String addressInAsset = getText(texts.get(element + 1), "");
                        System.out.println("address :" + addressInAsset);
                        sa.assertEquals(savedAddress.concat(","), addressInAsset);
                    } catch (Exception e) {
                        String addressInAsset = getText(texts.get(element + 2), "");
                        System.out.println("address :" + addressInAsset);
                        sa.assertEquals(savedAddress.concat(","), addressInAsset);
                    }
                }
            }
            sa.assertAll();
        }


    }


}
