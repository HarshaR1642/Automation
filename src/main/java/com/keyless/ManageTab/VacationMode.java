package com.keyless.ManageTab;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;

public class VacationMode extends BaseTest {

    @AndroidFindBy(accessibility = "MANAGE_TAB")
    @iOSXCUITFindBy(accessibility = "MANAGE_TAB")
    private MobileElement manageTab;

    @AndroidFindBy(accessibility = "thermostatDetails")
    @iOSXCUITFindBy(accessibility = "thermostatDetails")
    private MobileElement thermostatDetails;

    @AndroidFindBy(accessibility = "turnOffVacationMode")
    @iOSXCUITFindBy(accessibility = "turnOffVacationMode")
    private MobileElement turnOffVacationMode;

    @AndroidFindBy(accessibility = "vacationMode")
    @iOSXCUITFindBy(accessibility = "vacationMode")
    private MobileElement vacationMode;

    @AndroidFindBy(className = "android.widget.Switch")
    @iOSXCUITFindBy(accessibility = "vacationMode")
    private MobileElement enableDisableVacationMode;

    @AndroidFindBy(accessibility = "lightBehavior")
    @iOSXCUITFindBy(accessibility = "lightBehavior")
    private MobileElement lightBehavior;

    @AndroidFindBy(accessibility = "thermostatBehavior")
    @iOSXCUITFindBy(accessibility = "thermostatBehavior")
    private MobileElement thermostatBehavior;

    @AndroidFindBy(accessibility = "automateLights")
    @iOSXCUITFindBy(accessibility = "automateLights")
    private MobileElement automateLights;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(accessibility = "turnOnTime")
    @iOSXCUITFindBy(accessibility = "turnOnTime")
    private MobileElement turnOnTime;

    @AndroidFindBy(accessibility = "turnOffTime")
    @iOSXCUITFindBy(accessibility = "turnOffTime")
    private MobileElement turnOffTime;

    @AndroidFindBy(accessibility = "switchList")
    @iOSXCUITFindBy(accessibility = "switchList")
    private MobileElement switchList;

    @AndroidFindBy(accessibility = "disableThermostat")
    @iOSXCUITFindBy(accessibility = "disableThermostat")
    private MobileElement disableThermostat;

    @AndroidFindBy(accessibility = "6")
    @iOSXCUITFindBy(accessibility = "6")
    private MobileElement selectHour;

    @AndroidFindBy(accessibility = "0")
    @iOSXCUITFindBy(accessibility = "0")
    private MobileElement selectMinutes;

    @AndroidFindBy(id = "android:id/am_label")
    @iOSXCUITFindBy(id = "am")
    private MobileElement am;

    @AndroidFindBy(id = "android:id/pm_label")
    @iOSXCUITFindBy(id = "pm")
    private MobileElement pm;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement alertButton;

    String currentVacationModeState;

    public void clickOnManageTab() {
        click(manageTab, "Tap on the Manage Tab");
    }

    public void clickOnVacationMode() {
        click(vacationMode, "Tap on the vacationMode");
    }

    public void enableOrDisableVacationMode() {
        try{
            waitForVisibility(enableDisableVacationMode);
            currentVacationModeState = getText(enableDisableVacationMode,"Get current state of vacation mode ");
            if(!currentVacationModeState.equals("ON")){
                click(enableDisableVacationMode, "Tap on the vacationMode");
                try{
                    Thread.sleep(1200);
                    if (alertButton.isDisplayed()) {
                        click(alertButton);
                        Thread.sleep(150000);
                        click(enableDisableVacationMode, "Tap on the vacationMode");
                    }
                }catch (Exception ignored){
                }
                waitForVisibilityOfElementWithText(enableDisableVacationMode,"ON");
                currentVacationModeState = getText(enableDisableVacationMode,"Get current state of vacation mode ");
                System.out.println("currentVacationModeState: "+currentVacationModeState);
            }
        }catch (Exception e){
            System.out.println("Cannot Enable Vacation Mode");
        }
    }

    public void setLightBehavior() throws InterruptedException {
        try{
            waitforvisbility(lightBehavior,10);
        }catch (Exception e){
            return;
        }
        click(lightBehavior,"Tap on lightBehavior");
        waitForVisibility(automateLights);
        boolean isEnabled = "ON".equals(getText(automateLights,"Get current state of automateLights"));
        if (!isEnabled){
            click(automateLights,"Tap on automateLights");
        }
        waitForVisibility(automateLights);
        List<MobileElement> switches = getElements("switchList", "accessibilityId");
        if(switches.size() == 0){
            return;
        }
        // select turn on time
        click(turnOnTime,"Tap on turnOnTime");
        click(selectHour,"Tap on selectHour");
        click(selectMinutes,"Tap on selectMinutes");
        click(pm,"Tap on pm");
        click(alertButton,"Tap on ok");
        // select turn off time
        click(turnOffTime,"Tap on turnOffTime");
        click(selectHour,"Tap on selectHour");
        click(selectMinutes,"Tap on selectMinutes");
        click(am,"Tap on am");
        click(alertButton,"Tap on ok");
        Thread.sleep(1500);
        switches = getElements("switchList", "accessibilityId");
        click(switches.get(0),"Select switch");
        click(save,"Tap on save ");
        try {
            Thread.sleep(1000);
            if (alertButton.isDisplayed()) {
                click(alertButton);
                switches = getElements("switchList", "accessibilityId");
                click(switches.get(0), "Select switch");
                click(save, "Tap on save ");
            }
        }catch (Exception ignored){
        }

        waitForVisibility(lightBehavior);
    }

    public void setThermostatBehavior() throws InterruptedException {
        try{
            waitforvisbility(thermostatBehavior,10);
        }catch (Exception e){
            return;
        }
        click(thermostatBehavior,"Tap on thermostatBehavior");
        waitForVisibility(disableThermostat);
        boolean isEnabled = "ON".equals(getText(disableThermostat,"Get current state of thermostat switch"));
        if (!isEnabled){
            click(disableThermostat,"Tap on disableThermostat");
        }
        click(save,"Tap on save ");
        waitForVisibility(thermostatBehavior);
        getDriver().navigate().back();
        getDriver().navigate().back();
        click(thermostatDetails,"Tap on thermostatDetails");
        waitForVisibility(turnOffVacationMode);
        getDriver().navigate().back();
    }
}
