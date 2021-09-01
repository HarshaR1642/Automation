package com.keyless.Devices;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class Thermostat extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    String thermostatMode;
    String fanMode;
    String currentSelectedHeatingTemperature;
    String currentSelectedCoolingTemperature;

    @AndroidFindBy(accessibility = "ThermostatStatusTab")
    @iOSXCUITFindBy(accessibility = "ThermostatStatusTab")
    private MobileElement ThermostatStatusTab;

    @AndroidFindBy(accessibility = "ThermostatActivityTab")
    @iOSXCUITFindBy(accessibility = "ThermostatActivityTab")
    private MobileElement ThermostatActivityTab;

    @AndroidFindBy(accessibility = "thermostatCard")
    @iOSXCUITFindBy(accessibility = "thermostatCard")
    private MobileElement thermostatCard;

    @AndroidFindBy(accessibility = "heatingPoint")
    @iOSXCUITFindBy(accessibility = "heatingPoint")
    private MobileElement heatingPoint;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"operatingModeButton\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement operatingModeButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"fanModeButton\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement fanModeButton;

    @AndroidFindBy(accessibility = "auto")
    @iOSXCUITFindBy(accessibility = "auto")
    private MobileElement auto;

    @AndroidFindBy(accessibility = "on")
    @iOSXCUITFindBy(accessibility = "on")
    private MobileElement on;

    @AndroidFindBy(accessibility = "off")
    @iOSXCUITFindBy(accessibility = "off")
    private MobileElement off;

    @AndroidFindBy(accessibility = "heat")
    @iOSXCUITFindBy(accessibility = "heat")
    private MobileElement heat;

    @AndroidFindBy(accessibility = "cool")
    @iOSXCUITFindBy(accessibility = "cool")
    private MobileElement cool;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement currentTemperature;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement increaseTemperature;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement decreaseTemperature;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement currentCoolingTemperature;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement increaseCoolingTemperature;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement decreaseCoolingTemperature;

    @AndroidFindBy(accessibility = "Change Mode")
    @iOSXCUITFindBy(accessibility = "Change Mode")
    private MobileElement changeMode;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "")
    private MobileElement texts;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alert;

    public void navigateToThermostatDevice() {
        scrollToElement("thermostatCard", "accessibilityId", startX, startY, endX, endY);
        click(thermostatCard, "Tap on ThermostatCard");
    }

    public void clickOnOperatingModeButton() {
        click(operatingModeButton, "Tap on OperatingModeButton");
    }

    public void clickOnFanModeButton() {
        waitForVisibility(fanModeButton);
        fanMode = getText(fanModeButton, "Get the current FanMode ");
        click(fanModeButton, "Tap on FanModeButton");
    }

    public void changeFanMode() {
        waitForVisibility(auto);
        if (fanMode.equals("Auto")) {
            click(on, "Tap on FanMode 'ON' button");
            waitForVisibilityOfElementWithText(fanModeButton, "On");
        } else {
            click(auto, "Tap on FanMode 'Auto' button");
            waitForVisibilityOfElementWithText(fanModeButton, "Auto");
        }
    }

    public void changeOperatingModeAutomatically() {
        waitForVisibility(operatingModeButton);
        String currentMode = getText(operatingModeButton, "Get the current operatingMode ");
        clickOnOperatingModeButton();
        switch (currentMode) {
            case "Auto": {
                click(off, "Tap on OperatingMode 'Off' button");
                thermostatMode = "Off";
                break;
            }
            case "Off": {
                click(heat, "Tap on OperatingMode 'Heat' button");
                thermostatMode = "Heat";
                break;
            }
            case "Heat": {
                click(cool, "Tap on OperatingMode 'Cool' button");
                thermostatMode = "Cool";
                break;
            }
            case "Cool": {
                click(auto, "Tap on OperatingMode 'Auto' button");
                thermostatMode = "Auto";
                break;
            }
        }
    }

    public void changeOperatingMode(String mode) {
        thermostatMode = mode;
        waitForVisibility(changeMode);
        switch (mode) {
            case "Auto": {
                click(auto, "Tap on OperatingMode 'Auto' button");
                break;
            }
            case "Off": {
                click(off, "Tap on OperatingMode 'Off' button");
                break;
            }
            case "Heat": {
                click(heat, "Tap on OperatingMode 'Heat' button");
                break;
            }
            case "Cool": {
                click(cool, "Tap on OperatingMode 'Cool' button");
                break;
            }
        }
    }

    public void changeTemperature() {
        switch (thermostatMode) {
            case "Auto": {
                decreaseHeatingTemperature();
                increaseCoolingTemperature();
                int temp1 = Integer.parseInt(currentSelectedHeatingTemperature);
                int temp2 = Integer.parseInt(currentSelectedCoolingTemperature);
                if (Math.abs(temp1 - temp2) < 3) {
                    decreaseHeatingTemperature();
                }
                break;
            }
            case "Heat": {
                decreaseHeatingTemperature();
                break;
            }
            case "Cool": {
                increaseCoolingTemperature();
                break;
            }
        }
    }

    public String clickSaveButton() {
        System.out.println("thermostatMode: " + thermostatMode);
        click(save, "Tap on save button for OperatingMode");
        waitForVisibilityOfElementWithText(operatingModeButton, thermostatMode);
        String currentTime = getTime(0);

        return currentTime;
    }

    public String increaseHeatingTemperature() {
        waitForVisibility(currentTemperature);
        int temperature = Integer.parseInt(getText(currentTemperature,""));
        if (temperature >= 95) {
            swipeWithElements(currentTemperature, increaseTemperature, "Swipe to increase heating temperature");
        }else{
            swipeWithElements(currentTemperature, decreaseTemperature, "Swipe to increase heating temperature");
        }

        currentSelectedHeatingTemperature = getText(currentTemperature, "Get the selected heating temperature ");

        return currentSelectedHeatingTemperature;
    }

    public String decreaseHeatingTemperature() {
        waitForVisibility(currentTemperature);
        int temperature = Integer.parseInt(getText(currentTemperature,""));
        if (temperature <= 50) {
            swipeWithElements(currentTemperature, decreaseTemperature, "Swipe to increase heating temperature");
        }else{
            swipeWithElements(currentTemperature, increaseTemperature, "Swipe to decrease heating temperature");
        }

        currentSelectedHeatingTemperature = getText(currentTemperature, "Get the selected heating temperature ");

        return currentSelectedHeatingTemperature;

    }

    public String increaseCoolingTemperature() {
        MobileElement press, moveTo;
        if (thermostatMode.equals("Auto")) {
            press = currentCoolingTemperature;
            moveTo = decreaseCoolingTemperature;
        } else {
            press = currentTemperature;
            moveTo = decreaseTemperature;
        }

        swipeWithElements(press, moveTo, "Swipe to increase cooling temperature");

        if (thermostatMode.equals("Auto")) {
            currentSelectedCoolingTemperature = getText(currentCoolingTemperature, "Get the selected cooling temperature ");

            return currentSelectedCoolingTemperature;
        } else {
            currentSelectedCoolingTemperature = getText(currentTemperature, "Get the selected cooling temperature ");

            return currentSelectedCoolingTemperature;
        }
    }

    public String decreaseCoolingTemperature() {
        MobileElement press, moveTo;
        if (thermostatMode.equals("Auto")) {
            press = currentCoolingTemperature;
            moveTo = increaseCoolingTemperature;
        } else {
            press = currentTemperature;
            moveTo = increaseTemperature;
        }
        swipeWithElements(press, moveTo, "Swipe to decrease cooling temperature");

        if (thermostatMode.equals("Auto")) {
            currentSelectedCoolingTemperature = getText(currentCoolingTemperature, "Get the selected cooling temperature ");

            return currentSelectedCoolingTemperature;
        } else {
            currentSelectedCoolingTemperature = getText(currentTemperature, "Get the selected cooling temperature ");

            return currentSelectedCoolingTemperature;
        }
    }


    public void checkActivityForAutoMode(String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        String coolText = "Cooling setpoint " + currentSelectedCoolingTemperature + "\nvia app";
        String heatText = "Heating setpoint " + currentSelectedHeatingTemperature + "\nvia app";

        waitForVisibility(texts);
        Thread.sleep(2000);
        String activityStatus = getTextByIndex(1);
        sa.assertEquals(activityStatus, coolText);
        activityStatus = getTextByIndex(2);
        sa.assertEquals(activityStatus, time);

        activityStatus = getTextByIndex(3);
        sa.assertEquals(activityStatus, heatText);
        activityStatus = getTextByIndex(4);
        sa.assertEquals(activityStatus, time);

        activityStatus = getTextByIndex(5);
        sa.assertEquals(activityStatus, "Auto\nvia app");
        activityStatus = getTextByIndex(6);
        sa.assertEquals(activityStatus, time);

    }

    public void checkActivityForOffMode(String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();

        waitForVisibility(texts);
        Thread.sleep(2000);
        String activityStatus = getTextByIndex(1);
        sa.assertEquals(activityStatus, "Off\nvia app");
        activityStatus = getTextByIndex(2);
        sa.assertEquals(activityStatus, time);

    }

    public void checkActivityForHeatMode(String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        String heatText = "Heating setpoint " + currentSelectedHeatingTemperature + "\nvia app";

        waitForVisibility(texts);
        Thread.sleep(2000);
        String activityStatus = getTextByIndex(1);
        sa.assertEquals(activityStatus, heatText);
        activityStatus = getTextByIndex(2);
        sa.assertEquals(activityStatus, time);

        activityStatus = getTextByIndex(3);
        sa.assertEquals(activityStatus, "Heat\nvia app");
        activityStatus = getTextByIndex(4);
        sa.assertEquals(activityStatus, time);

    }

    public void checkActivityForCoolMode(String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        String coolText = "Cooling setpoint " + currentSelectedCoolingTemperature + "\nvia app";

        waitForVisibility(texts);
        Thread.sleep(2000);
        String activityStatus = getTextByIndex(1);
        sa.assertEquals(activityStatus, coolText);
        activityStatus = getTextByIndex(2);
        sa.assertEquals(activityStatus, time);

        activityStatus = getTextByIndex(3);
        sa.assertEquals(activityStatus, "Cool\nvia app");
        activityStatus = getTextByIndex(4);
        sa.assertEquals(activityStatus, time);

    }

    public void checkActivity(String time) throws InterruptedException {
        click(ThermostatActivityTab, "Tap on ThermostatActivityTab");

        switch (thermostatMode) {
            case "Auto": {
                checkActivityForAutoMode(time);
                break;
            }
            case "Off": {
                checkActivityForOffMode(time);
                break;
            }
            case "Heat": {
                checkActivityForHeatMode(time);
                break;
            }
            case "Cool": {
                checkActivityForCoolMode(time);
                break;
            }
        }

        click(ThermostatStatusTab, "Tap on ThermostatStatusTab");

    }

}

