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

public class Monitoring extends BaseTest {

    int height = (int) Math.round(getDriver().manage().window().getSize().height);
    int width = (int) Math.round(getDriver().manage().window().getSize().height);
    int startX = (int) Math.round(height * 0.5);
    int startY = (int) Math.round(height * 0.6);
    int endX = (int) Math.round(width * 0.5);
    int endY = (int) Math.round(height * 0.2);

    String time;

    @AndroidFindBy(accessibility = "monitoringCard")
    @iOSXCUITFindBy(accessibility = "monitoringCard")
    private MobileElement monitoringCard;

    @AndroidFindBy(accessibility = "MonitoringDetails")
    @iOSXCUITFindBy(accessibility = "MonitoringDetails")
    private MobileElement monitoringDetails;

    @AndroidFindBy(accessibility = "ScheduleTab")
    @iOSXCUITFindBy(accessibility = "ScheduleTab")
    private MobileElement scheduleTab;

    @AndroidFindBy(accessibility = "MonitoringActivityTab")
    @iOSXCUITFindBy(accessibility = "MonitoringActivityTab")
    private MobileElement monitoringActivityTab;

    @AndroidFindBy(accessibility = "ARMED")
    @iOSXCUITFindBy(accessibility = "ARMED")
    private MobileElement armed;

    @AndroidFindBy(accessibility = "DISARMED")
    @iOSXCUITFindBy(accessibility = "DISARMED")
    private MobileElement disarmed;

    @AndroidFindBy(accessibility = "arm")
    @iOSXCUITFindBy(accessibility = "arm")
    private MobileElement arm;

    @AndroidFindBy(accessibility = "disarm")
    @iOSXCUITFindBy(accessibility = "disarm")
    private MobileElement disarm;

    @AndroidFindBy(accessibility = "AddNewSchedule")
    @iOSXCUITFindBy(accessibility = "AddNewSchedule")
    private MobileElement addNewSchedule;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(accessibility = "enableDisableSchedule")
    @iOSXCUITFindBy(accessibility = "enableDisableSchedule")
    private MobileElement enableDisableSchedule;

    @AndroidFindBy(accessibility = "addEntry")
    @iOSXCUITFindBy(accessibility = "addEntry")
    private MobileElement addEntry;

    @AndroidFindBy(accessibility = "monitoringUndoEntry")
    @iOSXCUITFindBy(accessibility = "monitoringUndoEntry")
    private MobileElement monitoringUndoEntry;

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

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private MobileElement texts;

    @AndroidFindBy(accessibility = "Home, back")
    @iOSXCUITFindBy(accessibility = "Home, back")
    private MobileElement homeBack;

    public void navigateToMonitoringCard() {
        scrollToElement("monitoringCard", "accessibilityId", startX, startY, endX, endY);
        clickOnDeviceCard(monitoringCard, "Tap on monitoringCard");
    }

    public void navigateBack() {

        click(homeBack, "Navigate back to Dashboard");

    }

    public void clickOnMonitoringDetailsTab() {
        click(monitoringDetails, "Tap on Monitoring Details Tab");

    }

    public void clickOnMonitoringActivityTab() {
        click(monitoringActivityTab, "Tap on Activity Tab");

    }

    public void clickOnScheduleTab() {
        click(scheduleTab, "Tap on scheduleTab");

    }

    public void clickOnEnableDisableSchedule() {
        waitForVisibility(enableDisableSchedule);
        String state = getText(enableDisableSchedule, "Get the state of schedule ON/OFF ");
        if (state.equals("OFF")) {
            click(enableDisableSchedule);
        }
        waitForVisibility(save);
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

    public void selectArmModeForScheduler() {
        SoftAssert sa = new SoftAssert();
        click(selectNewMode, "Tap on selectMode");
        click(arm, "Tap on selectMode");
        clickSaveButton();
        waitForVisibility(selectNewMode);
        String mode = getText(selectNewMode, "Get the selected mode ");
        sa.assertEquals("Arm", mode);
        sa.assertAll();
    }

    public void selectDisarmModeForScheduler() {
        SoftAssert sa = new SoftAssert();
        click(selectNewMode, "Tap on selectMode");
        click(disarm, "Tap on selectMode");
        clickSaveButton();
        waitForVisibility(selectNewMode);
        String mode = getText(selectNewMode, "Get the selected mode ");
        sa.assertEquals("Disarm", mode);
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
            int x = (int) Math.floor(monitoringUndoEntry.getSize().getWidth() * 0.9);
            int y = monitoringUndoEntry.getLocation().getY() + monitoringUndoEntry.getSize().getHeight() / 2;
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
        waitForVisibility(save);
        List<MobileElement> entries = getElements("deleteEntry", "accessibilityId");
        while (entries.size() != 0) {
            click(entries.get(0), "Tap on delete icon");
            Thread.sleep(1000);
            entries = getElements("deleteEntry", "accessibilityId");
        }

    }

    public void addSchedule() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(save);
        List<MobileElement> addNewScheduleButton = getElements("AddNewSchedule", "accessibilityId");
        if (addNewScheduleButton.size() == 0) {
            deleteSchedule();
        }
        if (addNewScheduleButton.size() == 0) {
            deleteAllVisibleEntries();
        }
        List<MobileElement> inActiveDays = getElements("inActiveDays", "accessibilityId");
        for (MobileElement inActiveDay : inActiveDays) {
            click(inActiveDay, "Tap on inActive days");
            Thread.sleep(1000);
        }
        List<MobileElement> activeDays = getElements("activeDays", "accessibilityId");
        click(activeDays.get(3), "Tap on Wednesday");
        click(addNewSchedule, "Tap on AddNewSchedule button");
        waitForVisibility(save);
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
        waitForVisibility(save);
        List<MobileElement> deleteSchedules = getElements("deleteSchedule", "accessibilityId");
        while (deleteSchedules.size() != 0) {
            clickOndeleteSchedule();
            Thread.sleep(1200);
            deleteSchedules = getElements("deleteSchedule", "accessibilityId");
        }
    }

    public void clickSaveButton() {
        SoftAssert sa = new SoftAssert();
        click(save, "Tap on save schedule");
        waitForVisibility(alertButton);
        sa.assertEquals(getText(alertTitle, "Get the Alert Title "), "Success");
        sa.assertEquals(getText(alertMessage, "Get the Alert Message "), "Successfully updated.");
        click(alertButton, "Tap on 'ok'");
    }

    public String clickToDisarm() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(disarm);
        Thread.sleep(2000);
        waitForVisibility(disarmed);
        return systime;

    }

    public String clickToArm() throws Exception {
        String systime = getTime(0);
        System.out.println(systime);
        click(arm);
        Thread.sleep(2000);
        waitForVisibility(armed);
        return systime;

    }


    public String getState() {
        try {
            waitforvisbility(armed, 5);
            return "armed";
        } catch (Exception e) {
            return "disarmed";
        }

    }

    public void checkActivity(String state, String time) throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(texts);
        Thread.sleep(2000);
        String activity_status = getTextByIndex(1);
        if (state.equals("armed")) {
            sa.assertEquals("Arm", activity_status);
        } else {
            sa.assertEquals("Disarm", activity_status);
        }
        activity_status = getTextByIndex(2);
        sa.assertEquals(time, activity_status);
    }


}
