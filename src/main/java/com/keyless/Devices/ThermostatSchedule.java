package com.keyless.Devices;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ThermostatSchedule extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.4);

    String time;
    String heatingTemperature;
    String coolingTemperature;
    Thermostat thermostat = new Thermostat();

    @AndroidFindBy(accessibility = "thermostatCard")
    @iOSXCUITFindBy(accessibility = "thermostatCard")
    private MobileElement thermostatCard;

    @AndroidFindBy(accessibility = "ThermostatScheduleTab")
    @iOSXCUITFindBy(accessibility = "ThermostatScheduleTab")
    private MobileElement ThermostatScheduleTab;

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

    @AndroidFindBy(accessibility = "saveSchedule")
    @iOSXCUITFindBy(accessibility = "saveSchedule")
    private MobileElement saveSchedule;

    @AndroidFindBy(accessibility = "onEnableDisableSchedule")
    @iOSXCUITFindBy(accessibility = "onEnableDisableSchedule")
    private MobileElement onEnableDisableSchedule;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(accessibility = "addEntry")
    @iOSXCUITFindBy(accessibility = "addEntry")
    private MobileElement addEntry;

    @AndroidFindBy(accessibility = "AddNewSchedule")
    @iOSXCUITFindBy(accessibility = "AddNewSchedule")
    private MobileElement addNewSchedule;

    @AndroidFindBy(accessibility = "thermostatUndoEntry")
    @iOSXCUITFindBy(accessibility = "thermostatUndoEntry")
    private MobileElement thermostatUndoEntry;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"deleteEntry\"])[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement deleteEntry;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"deleteSchedule\"])[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement deleteSchedule;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"selectNewTime\"])[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement selectNewTime;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"selectNewMode\"])[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement selectNewMode;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"heatTemp\"])[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement heatTemp;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"coolTemp\"])[1]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement coolTemp;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"activeDays\"])[7]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement wednesday;

    @AndroidFindBy(accessibility = "12")
    @iOSXCUITFindBy(accessibility = "12")
    private MobileElement selectHour;

    @AndroidFindBy(id = "android:id/hours")
    @iOSXCUITFindBy(id = "")
    private MobileElement selectedHour;

    @AndroidFindBy(accessibility = "15")
    @iOSXCUITFindBy(accessibility = "15")
    private MobileElement selectMinutes;

    @AndroidFindBy(id = "android:id/minutes")
    @iOSXCUITFindBy(id = "")
    private MobileElement selectedMinutes;

    @AndroidFindBy(id = "android:id/am_label")
    @iOSXCUITFindBy(id = "")
    private MobileElement am;

    @AndroidFindBy(id = "android:id/alertTitle")
    @iOSXCUITFindBy(id = "")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "")
    private MobileElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertButton;

    public void navigateToThermostatDevice() {
        scrollToElement("thermostatCard", "accessibilityId", startX, startY, endX, endY);
        click(thermostatCard, "Tap on ThermostatCard");
    }

    public void clickOnThermostatScheduleTab() {
        click(ThermostatScheduleTab, "Tap on ThermostatScheduleTab");
    }

    public void clickOnEnableDisableSchedule() {
        waitForVisibility(onEnableDisableSchedule);
        String state = getText(onEnableDisableSchedule, "Get the state of schedule ON/OFF ");
        if (state.equals("OFF")) {
            click(onEnableDisableSchedule);
        }
        waitForVisibility(saveSchedule);
    }

    public void selectSchedulerTime() {
        time = "";
        waitForVisibility(selectNewTime);
        click(selectNewTime, "Tap on Select Time");
        waitForVisibility(selectHour);
        click(selectHour, "Tap on Select Hour");
        time = time + getText(selectedHour, "Get the selected hour ") + ":";
        click(selectMinutes, "Tap on Select Minutes");
        time = time + getText(selectedMinutes, "Get the selected minutes ");
        click(am, "Select 'am'");
        time = time + " AM";
        click(alertButton, "Tap on 'ok'");
        try{
            Thread.sleep(1200);
            if(alertButton.isDisplayed()){
                click(alertButton);
            }
        }catch(Exception ignored){
        }

    }

    public void verifySelectedTime() {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(selectNewTime);
        String selectedTime = getText(selectNewTime, "Get the selected time ");
        sa.assertEquals(time, selectedTime);
        sa.assertAll();

    }

    public void selectAutoModeForScheduler() {
        SoftAssert sa = new SoftAssert();
        click(selectNewMode, "Tap on selectMode");
        thermostat.changeOperatingMode("Auto");
        heatingTemperature = thermostat.decreaseHeatingTemperature();
        coolingTemperature = thermostat.increaseCoolingTemperature();
        int temp1 = Integer.parseInt(heatingTemperature);
        int temp2 = Integer.parseInt(coolingTemperature);
        if (Math.abs(temp1 - temp2) < 3) {
            heatingTemperature = thermostat.decreaseHeatingTemperature();
        }
        click(save, "Tap on save button");
        clickSaveButton();
        waitForVisibility(selectNewMode);
        String mode = getText(selectNewMode, "Get the selected mode ");
        sa.assertEquals("Auto", mode);
        sa.assertEquals(heatingTemperature.concat("°F - "), getText(heatTemp, "Get the heating temperature for scheduler "));
        sa.assertEquals(coolingTemperature.concat("°F"), getText(coolTemp, "Get the cooling temperature for scheduler "));
        System.out.println("heatingTemperature: " + heatingTemperature + " coolingTemperature: " + coolingTemperature);
        sa.assertAll();
    }

    public void selectOffModeForScheduler() {
        SoftAssert sa = new SoftAssert();
        click(selectNewMode, "Tap on selectMode");
        thermostat.changeOperatingMode("Off");
        click(save, "Tap on save button");
        clickSaveButton();
        waitForVisibility(selectNewMode);
        String mode = getText(selectNewMode, "Get the selected mode ");
        sa.assertEquals("Off", mode);
        sa.assertAll();
    }

    public void selectHeatModeForScheduler() {
        SoftAssert sa = new SoftAssert();
        click(selectNewMode, "Tap on selectMode");
        thermostat.changeOperatingMode("Heat");
        heatingTemperature = thermostat.decreaseHeatingTemperature();
        click(save, "Tap on save button");
        clickSaveButton();
        waitForVisibility(selectNewMode);
        String mode = getText(selectNewMode, "Get the selected mode ");
        sa.assertEquals("Heat", mode);
        sa.assertEquals(heatingTemperature.concat("°F"), getText(heatTemp, "Get the heating temperature for scheduler "));
        System.out.println("heatingTemperature: " + heatingTemperature);
        sa.assertAll();
    }

    public void selectCoolModeForScheduler() {
        SoftAssert sa = new SoftAssert();
        click(selectNewMode, "Tap on selectMode");
        thermostat.changeOperatingMode("Cool");
        coolingTemperature = thermostat.increaseCoolingTemperature();
        click(save, "Tap on save button");
        clickSaveButton();
        waitForVisibility(selectNewMode);
        String mode = getText(selectNewMode, "Get the selected mode ");
        sa.assertEquals("Cool", mode);
        sa.assertEquals(coolingTemperature.concat("°F"), getText(coolTemp, "Get the cooling temperature for scheduler "));
        System.out.println("coolingTemperature: " + coolingTemperature);
        sa.assertAll();
    }

    public void undoEntry() throws Exception {
        try {
            SoftAssert sa = new SoftAssert();
            waitForVisibility(selectNewTime);
            List<MobileElement> elements = getElements("selectNewTime", "accessibilityId");
            if (elements.size() <= 2) {
                click(addEntry, "Tap on Add Entry");
            }
            waitForVisibility(selectNewTime);
            String scheduleTimeBeforeDeleting = getText(selectNewTime, "Get the time ");
            click(deleteEntry, "Tap on delete icon");
            int x = (int) Math.floor(thermostatUndoEntry.getSize().getWidth() * 0.9);
            int y = thermostatUndoEntry.getLocation().getY() + thermostatUndoEntry.getSize().getHeight() / 2;
            new TouchAction<>((PerformsTouchActions) getDriver())
                    .press(PointOption.point(x, y))
                    .release()
                    .perform();
            sa.assertEquals(scheduleTimeBeforeDeleting, getText(selectNewTime, "Get the time of schedule "));
            sa.assertAll();
        } catch (Exception e) {
            System.out.println("Error in UndoEntry");
        } finally {
            getDriver().navigate().back();
            getDriver().navigate().back();
        }

    }

    public void deleteAllVisibleEntries() throws InterruptedException {
        waitForVisibility(saveSchedule);
        List<MobileElement> entries = getElements("deleteEntry", "accessibilityId");
        while (entries.size() != 0) {
            click(entries.get(0), "Tap on delete icon");
            Thread.sleep(1000);
            entries = getElements("deleteEntry", "accessibilityId");
        }

    }

    public void addSchedule() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(saveSchedule);
        List<MobileElement> addNewScheduleButton = getElements("AddNewSchedule", "accessibilityId");
        if (addNewScheduleButton.size() == 0) {
            deleteSchedule();
        }
        if (addNewScheduleButton.size() == 0) {
            deleteAllVisibleEntries();
        }
        List<MobileElement> inActiveDays = getElements("inActiveDays", "accessibilityId");
        for (int i = 0; i < inActiveDays.size(); i++) {
            click(inActiveDays.get(i), "Tap on inActive days");
            Thread.sleep(1000);
        }
        List<MobileElement> activeDays = getElements("activeDays", "accessibilityId");
        click(activeDays.get(3), "Tap on Wednesday");
        click(addNewSchedule, "Tap on AddNewSchedule button");
        waitForVisibility(saveSchedule);
        sa.assertEquals(getText(wednesday, "Get active day from newly added schedule "), "W");
        clickSaveButton();
        sa.assertAll();
    }

    public void clickOndeleteSchedule() {
        SoftAssert sa = new SoftAssert();
        click(deleteSchedule, "Tap on delete schedule");
        waitForVisibility(alertButton);
        sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Delete Schedule");
        sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Do you want to delete this schedule?");
        click(alertButton, "Tap on 'ok'");
        waitForVisibility(addEntry);
        sa.assertAll();
    }

    public void deleteSchedule() throws InterruptedException {
        waitForVisibility(saveSchedule);
        List<MobileElement> deleteSchedules = getElements("deleteSchedule", "accessibilityId");
        while (deleteSchedules.size() != 0) {
            clickOndeleteSchedule();
            Thread.sleep(1200);
            deleteSchedules = getElements("deleteSchedule", "accessibilityId");
        }
    }

    public void clickSaveButton() {
        SoftAssert sa = new SoftAssert();
        click(saveSchedule, "Tap on save schedule");
        waitForVisibility(alertButton);
        sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Success");
        sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Successfully updated.");
        click(alertButton, "Tap on 'ok'");
    }

}

