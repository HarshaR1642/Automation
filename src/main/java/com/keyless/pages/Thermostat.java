package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Thermostat extends BaseTest {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='thermostatMode']/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='thermostatMode'])[1]")
    private MobileElement Dashboard_ChngModeBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='close']/android.view.ViewGroup[2]")
    private MobileElement ThermoWindow_Close;


    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Change Mode']")
    private MobileElement windowTitle;

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


    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Change Mode']")
    private MobileElement ChangeModeWindow_Thermotxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='In off mode, you cannot select any thermostat values.']")
    private MobileElement OffModeWindow_Thermotxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Select Heating Temperature']")
    private MobileElement HeatModeWindow_Thermotxt;


    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Select Cooling Temperature']")
    private MobileElement CoolModeWindow_Thermotxt;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='residentHome'])[2]/android.view.ViewGroup[1]")
    private MobileElement selecthome;

    public Thermostat tapSlcthome() {
        click(selecthome, "User selects the home");
        return this;
    }

    public Thermostat tapDshBrdModeBtn() {
        System.out.println("User Tap on the Thermostat mode button on dashbaord");
        click(Dashboard_ChngModeBtn, "User Tap on the Thermostat mode button on dashbaord");
        return this;
    }

    public Thermostat tapCloseBtn() {
        System.out.println("User Tap on Close button of change Mode screen");
        click(ThermoWindow_Close, "User Tap on Close button of change Mode screen");
        return this;
    }


    public Thermostat tapAutoModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_AutoBtn, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat SwipeCoolMode() {
        System.out.println("User swipe the Cool Mode button");

        swipeRight(Thermo_CoolSetPoint);
        return this;
    }


    public Thermostat SwipeHeatMode() {
        System.out.println("User swipe the Cool Mode button");
        click(Thermo_CoolSetPoint, "User swipe the Cool Mode button");

        return this;
    }

    public Thermostat tapOffModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_OFFBtn, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat tapCoolModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_CoolBtn, "User Tap on the change mode to Auto button");
        return this;
    }

    public Thermostat tapHeatModeBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_HeatBtn, "User Tap on the change mode to Auto button");
        return this;
    }


    public Thermostat_detail tapSaveBtn() {
        System.out.println("User Tap on the change mode to Auto button");
        click(Thermo_SaveBtn, "User Tap on the change mode to Auto button");
        return new Thermostat_detail();
    }


    public String chnagewindowTxt() {
        String chngewindowtxt = getText(ChangeModeWindow_Thermotxt, "Chnage thermos window text");
        System.out.println("Chnage thermos window text" + ChangeModeWindow_Thermotxt);
        return chngewindowtxt;
    }


}
