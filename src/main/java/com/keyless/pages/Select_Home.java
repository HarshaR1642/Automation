package com.keyless.pages;

import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Select_Home extends BaseTest {


    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='SelectHome']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SelectHome']")
    private MobileElement SelectHometxt;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='residentHome'])/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='residentHome'])[4]")
    private MobileElement SelectHome;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='managerHome'])/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='managerHome'])[4]")
    private MobileElement managerHome;

    @iOSXCUITFindBy(accessibility = "Allow")
    private MobileElement allow;

    public String SelectHometxt() {
        System.out.println(SelectHometxt);
        String Page_title = getText(SelectHometxt, "The page title is -");
        System.out.println("The page Title is -" + Page_title);
        return Page_title;
    }

    public Thermostat taponSelectHome() throws Exception {
        if (getPlatform().equals("iOS")) {
            click(allow);
        }
        System.out.println("Tap on the Home presnt In the list");
        click(SelectHome);
        Thread.sleep(2000);
        return new Thermostat();
    }

    public Thermostat taponManagerHome() throws Exception {
        System.out.println("Tap on the Home presnt In the list");
        click(managerHome);
        Thread.sleep(2000);
        return new Thermostat();
    }

}
