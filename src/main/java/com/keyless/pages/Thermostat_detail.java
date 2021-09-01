package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Thermostat_detail extends BaseTest {


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='thermostatDetails']/android.view.ViewGroup")
    private MobileElement Thermo_chngmode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='fanModeButton']/android.view.ViewGroup")
    private MobileElement Thermo_fan;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='close']/android.view.ViewGroup[2]")
    private MobileElement ThermoWindow_Close;


    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Change Mode']")
    private MobileElement windowTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='operatingModeButton']/android.view.ViewGroup")
    private MobileElement operteMode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='auto']/android.widget.TextView")
    private MobileElement Thermo_AutoBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Select Heating Temperature']")
    private MobileElement SlectHeatModeTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Select Cooling Temperature']")
    private MobileElement SlectCoolModeTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='In off mode, you cannot select any thermostat values.']")
    private MobileElement SlectOffModeTxt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement Thermo_HeatSetPoint;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement Thermo_CoolSetPoint;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='save']/android.view.ViewGroup")
    private MobileElement Thermo_SaveBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='off']/android.widget.TextView")
    private MobileElement Thermo_OFFBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='heat']/android.widget.TextView")
    private MobileElement Thermo_HeatBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cool']/android.widget.TextView")
    private MobileElement Thermo_CoolBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='close']/android.view.ViewGroup[2]")
    private MobileElement Thermo_CloseBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='fanModeButton']/android.view.ViewGroup")
    private MobileElement Thermo_Fanmode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='auto']/android.widget.TextView")
    private MobileElement Thermo_FanAuto;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='on']/android.widget.TextView")
    private MobileElement Thermo_FanOn;


    public Thermostat_detail tapDshBrdModeBtn() {
        System.out.println("User Tap on the Thermostat mode button on thermostat detail page");
        click(Thermo_chngmode, "User Tap on the Thermostat mode button on dashbaord");
        return this;
    }

    public Thermostat_detail tapOperateModeBtn() {
        System.out.println("User Tap on the change operate button");
        click(operteMode, "User Tap on the change operate mode button");
        return this;
    }

    public Thermostat_detail SwipeCoolMode() {
        System.out.println("User swipe the Cool Mode button");

        swipeRight(Thermo_CoolSetPoint);
        return this;
    }


    public Thermostat_detail SwipeHeatMode() {
        System.out.println("User swipe the Cool Mode button");
        click(Thermo_CoolSetPoint, "User swipe the Cool Mode button");

        return this;
    }

    public Thermostat_detail tapOffModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_OFFBtn, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat_detail tapCoolModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_CoolBtn, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat_detail tapHeatModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_HeatBtn, "User Tap on the change mode to Auto button");
        return this;
    }


    public Thermostat_detail tapSaveBtn() {

        click(Thermo_SaveBtn, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat_detail FanMode() {
        click(Thermo_Fanmode, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat_detail FanModeAuto() {
        click(Thermo_FanAuto, "User Tap on the change mode to Auto button");
        return this;
    }

    public ThermostatScheduler FanModeOn() {
        click(Thermo_FanOn, "User Tap on the change mode to Auto button");
        return new ThermostatScheduler();
    }


}
