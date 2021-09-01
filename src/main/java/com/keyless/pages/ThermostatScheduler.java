package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ThermostatScheduler extends BaseTest {


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ThermostatScheduleTab']/android.widget.TextView")
    private MobileElement Thermo_Scheduler;

    @AndroidFindBy(accessibility = "onEnableDisableSchedule")
    private MobileElement Thermo_disableSceduler;

    @AndroidFindBy(accessibility = "onEnableDisableSchedule")
    private MobileElement Thermo_enableSceduler;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='addEntry']/android.widget.TextView")
    private MobileElement Thermo_AddScheduler;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='selectNewMode'])[3]/android.view.ViewGroup")
    private MobileElement Thermo_ChngeMode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='auto']/android.widget.TextView")
    private MobileElement Scheduler_ModeAuto;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='heat']/android.widget.TextView")
    private MobileElement Scheduler_ModeHeat;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cool']/android.widget.TextView")
    private MobileElement Scheduler_ModeCool;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='off']/android.widget.TextView")
    private MobileElement Scheduler_ModeOff;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='save']/android.widget.TextView")
    private MobileElement Scheduler_Save;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='saveSchedule']")
    private MobileElement Scheduler_SaveNewScheduler;


    public ThermostatScheduler SlctScheduler() {
        click(Thermo_Scheduler, "Slect the Scheduler tab.");
        return this;
    }

    public ThermostatScheduler disableScheduler() {

        click(Thermo_disableSceduler, "Disable the Scheduler");
        return this;
    }

    public ThermostatScheduler enableScheduler() {
        click(Thermo_enableSceduler, "Enable the Scheduler");
        return this;
    }


    public ThermostatScheduler DtailoperatingMode() {

        click(Thermo_Scheduler, "User Tap on the Thermostat mode button on dashbaord");
        return this;
    }


    public ThermostatScheduler AddNewSchdlr() {
        click(Thermo_AddScheduler, "Thermostat add a new Scheduler");
        return this;
    }

    public ThermostatScheduler chngeScedlur() {
        click(Thermo_ChngeMode, "User Tap on the Thermostat mode change button on scheduler");
        return this;

    }

    public ThermostatScheduler chngeToAuto() {
        click(Scheduler_ModeAuto, "User Tap on the Thermostat mode change button on scheduler");
        return this;

    }

    public ThermostatScheduler chngeToHeat() {
        click(Scheduler_ModeHeat, "User Tap on the Thermostat mode change it to Heat");
        return this;

    }

    public ThermostatScheduler chngeToCool() {
        click(Scheduler_ModeCool, "User Tap on the Thermostat mode change button on scheduler");
        return this;

    }

    public ThermostatScheduler chngeToOff() {
        click(Scheduler_ModeOff, "User Tap on the Thermostat mode change button on scheduler");
        return this;
    }

    public ThermostatScheduler ShdlrSave() {
        click(Scheduler_Save, "User Tap on the Thermostat mode change button on scheduler");
        return this;

    }

    public ThermostatScheduler ShdlrnewSave() {
        click(Scheduler_SaveNewScheduler, "User Tap on the Thermostat mode change button on scheduler");
        return this;

    }

}
