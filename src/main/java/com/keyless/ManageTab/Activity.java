package com.keyless.ManageTab;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Activity extends BaseTest {

    List<String> devices = new ArrayList<String>();

    int startX = (int) Math.round(getDriver().manage().window().getSize().width * 0.5);
    int startY = (int) Math.round(getDriver().manage().window().getSize().height * 0.6);
    int endX = (int) Math.round(getDriver().manage().window().getSize().width * 0.5);
    int endY = (int) Math.round(getDriver().manage().window().getSize().height * 0.2);

    @AndroidFindBy(accessibility = "MANAGE_TAB")
    @iOSXCUITFindBy(accessibility = "MANAGE_TAB")
    private MobileElement manageTab;

    @AndroidFindBy(accessibility = "deviceActivities")
    @iOSXCUITFindBy(accessibility = "deviceActivities")
    private MobileElement deviceActivities;

    @AndroidFindBy(accessibility = "activityFilter")
    @iOSXCUITFindBy(accessibility = "activityFilter")
    private MobileElement activityFilter;

    @AndroidFindBy(accessibility = "deviceFilterList")
    @iOSXCUITFindBy(accessibility = "deviceFilterList")
    private MobileElement deviceFilterList;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='deviceFilterList']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement deviceNames;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "")
    private MobileElement staticText;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    private String androidXPathForDevices = "//android.view.ViewGroup[@content-desc='deviceFilterList']/android.widget.TextView";

    int x,y;

    public void clickOnManageTab() {
        click(manageTab, "Click on the Manage Tab");
    }

    public void clickOnDeviceActivities() {
        click(deviceActivities, "Click on the Device Activities");
    }

    public void clickOnActivityFilter() {
        waitForVisibility(activityFilter);
        x = activityFilter.getLocation().getX();
        y = activityFilter.getLocation().getY();
        click(activityFilter, "Click on the Activity Filter");
        waitForVisibility(deviceFilterList);
    }

    public void navigateBack() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(PointOption.point(x, y))
                .release()
                .perform();
        click(homeBack);
    }

    public void checkActivity() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        List<MobileElement> deviceList = getElements(androidXPathForDevices, "xPath");

        while (true) {
            for (int i = 0; i < deviceList.size(); i++) {
                waitForVisibility(deviceNames);
                deviceList = getElements(androidXPathForDevices, "xPath");
                if (deviceList.size() >= i + 1) {
                    String deviceName = getText(deviceList.get(i), "");
                    if (!devices.contains(deviceName)) {
                        devices.add(deviceName);
                        click(deviceList.get(i));
                        Thread.sleep(1500);
                        waitForVisibility(staticText);
                        Thread.sleep(1500);
                        List<MobileElement> texts = getElements("android.widget.TextView", "className");
                        int j = 0;
                        for (j = 0; j < texts.size(); j++) {
                            String text = getText(texts.get(j), "");
                            if (text.equals("Activities")) {
                                j++;
                                break;
                            }
                        }
                        sa.assertEquals(getText(texts.get(j), ""), deviceName);
                        click(activityFilter);

                    }

                }

            }
            waitForVisibility(deviceNames);
            boolean isEndReached = scroll(startX, startY, endX, endY);

            if (isEndReached) {
                navigateBack();
                return;
            }
            sa.assertAll();
        }


    }


}
