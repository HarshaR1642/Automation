package com.keyless.ManageTab;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;

public class DeviceNames extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().width);
    int startX = (int) Math.round(width * 0.5);
    int startY = (int) Math.round(height * 0.7);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    List<String> devices = new ArrayList<String>();

    @AndroidFindBy(accessibility = "HOME_TAB")
    @iOSXCUITFindBy(accessibility = "HOME_TAB")
    private MobileElement homeTab;

    @AndroidFindBy(accessibility = "MANAGE_TAB")
    @iOSXCUITFindBy(accessibility = "MANAGE_TAB")
    private MobileElement manageTab;

    @AndroidFindBy(accessibility = "deviceNames")
    @iOSXCUITFindBy(accessibility = "deviceNames")
    private MobileElement deviceNames;

    @AndroidFindBy(accessibility = "selectHome")
    @iOSXCUITFindBy(accessibility = "selectHome")
    private MobileElement selectHome;

    @AndroidFindBy(accessibility = "deviceNamesList")
    @iOSXCUITFindBy(accessibility = "deviceNamesList")
    private MobileElement deviceNamesList;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"contactSensorCard\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement deviceNameInContactSensorCard;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"motionSensorCard\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement deviceNameInMotionSensorCard;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alert;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "")
    private MobileElement staticText;

    private final String staticTextClassName = "android.widget.TextView";

    public void clickOnHomeTab() {
        click(homeTab, "Tap on the Home Tab");
    }

    public void clickOnManageTab() {
        click(manageTab, "Tap on the Manage Tab");
    }

    public void clickOnDeviceNames() {
        click(deviceNames, "Tap on Device Names");
        waitForVisibility(save);
    }

    public void tap(MobileElement element) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(ElementOption.element(element))
                .release()
                .perform();
    }

    public boolean checkUpdatedDeviceNameInDetailsScreen(String name) {
        waitForVisibility(staticText);
        List<MobileElement> texts = getElements(staticTextClassName, "className");
        for (MobileElement mobileElement : texts) {
            String text = getText(mobileElement, "");
            if (text.equals(name)) {
                getDriver().navigate().back();
                clickOnManageTab();
                clickOnDeviceNames();
                return true;
            }
        }
        return false;
    }

    public void checkUpdatedDeviceNameInDashboard(String name) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        getDriver().navigate().back();
        getDriver().navigate().back();
        Thread.sleep(2000);
        boolean isTop = false;
        List<MobileElement> texts = getElements(staticTextClassName, "className");
        while (true) {
            for (MobileElement mobileElement : texts) {
                String text = getText(mobileElement, "");
                if (text.equals(name)) {
                    if (getElements("contactSensorCard", "accessibilityId").size() != 0) {
                        if (getText(deviceNameInContactSensorCard, "").equals(name)) {
                            clickOnManageTab();
                            clickOnDeviceNames();
                            return;
                        }
                    }

                    if (getElements("motionSensorCard", "accessibilityId").size() != 0) {
                        if (getText(deviceNameInMotionSensorCard, "").equals(name)) {
                            clickOnManageTab();
                            clickOnDeviceNames();
                            return;
                        }
                    }

                    tap(mobileElement);
                    sa.assertTrue(checkUpdatedDeviceNameInDetailsScreen(name));
                    return;
                }
            }
            if (!isTop && getElements("selectHome", "accessibilityId").size() == 0) {
                scroll(startX, endY, endX, startY);
                if (getElements("selectHome", "accessibilityId").size() != 0) {
                    isTop = true;
                }
            } else {
                scroll(startX, startY, endX, endY);
            }
            Thread.sleep(2000);
            texts = getElements(staticTextClassName, "className");
        }
    }

    public void clickSaveButton() {
        SoftAssert sa = new SoftAssert();
        click(save, "Tap on save button");
        sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Success");
        sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Successfully updated.");
        click(alert, "Tap on 'ok'");
        waitForVisibility(save);
    }


    public void updateDeviceNames() throws InterruptedException {
        List<MobileElement> deviceList = getElements("deviceNamesList", "accessibilityId");
        int deviceCount = 1;
        while (true) {
            for (int i = 0; i < deviceList.size(); i++) {
                waitForVisibility(deviceNamesList);
                deviceList = getElements("deviceNamesList", "accessibilityId");
                if (deviceList.size() >= i + 1) {
                    String deviceName = getText(deviceList.get(i), "");
                    if (!devices.contains(deviceName)) {
                        String newName = "Device " + Integer.toString(deviceCount);
                        devices.add(newName);
                        //devices.add(deviceName);
                        devices.add(deviceName);
                        sendKeys(deviceList.get(i), newName);
                        //sendKeys(deviceList.get(i),deviceName);
                        clickSaveButton();
                        checkUpdatedDeviceNameInDashboard(newName);
                        //checkUpdatedDeviceNameInDashboard(deviceName);
                        deviceCount++;
                        if (deviceCount == 6) {
                            getDriver().navigate().back();
                            return;
                        }
                    }
                }
            }
            waitForVisibility(deviceNamesList);
            boolean isEndReached = scroll(startX, startY, endX, endY);

            if (isEndReached) {
                getDriver().navigate().back();
                return;
            }
        }
    }
}
	
	
	
	
	
	
	

