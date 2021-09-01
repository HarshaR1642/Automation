package com.keyless.Other;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class RegionFilterForAssets extends BaseTest {

    String homeName;
    String freeDeviceName;

    @AndroidFindBy(accessibility = "RegionMarketFilter")
    @iOSXCUITFindBy(accessibility = "RegionMarketFilter")
    private MobileElement RegionMarketFilter;

    @AndroidFindBy(accessibility = "applyFilter")
    @iOSXCUITFindBy(accessibility = "applyFilter")
    private MobileElement applyFilter;

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    @iOSXCUITFindBy(className = "")
    private MobileElement checkedText;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(className = "")
    private MobileElement editText;

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSXCUITFindBy(className = "")
    private MobileElement texts;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"managerHome\"])[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement managerHomeName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.View/android.view.ViewGroup/android.view.View[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement freeDevicesTab;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"freeDevices\"])[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement freeDevice;

    public void clickOnFreeDevices() {
        click(freeDevicesTab, "Tap on Free Devices");
    }

    public void clickOnFilter() {
        click(RegionMarketFilter, "Tap on Filter");
    }

    public void applyFilter() {
        click(applyFilter, "Tap on Apply Filter");
        waitForVisibility(RegionMarketFilter);
    }

    public int getTotalCountOfRegionsOrMarkets() throws InterruptedException {
        Thread.sleep(1000);
        List<MobileElement> elements = getElements("android.widget.CheckedTextView", "className");

        return elements.size();

    }

    public String getHomeName() {
        List<MobileElement> homes = getElements("managerHome", "accessibilityId");
        if (homes.size() != 0) {
            return getText(managerHomeName, "get Home Name ");
        }

        return null;

    }

    public String getFreeDeviceName() {
        List<MobileElement> freeDevices = getElements("freeDevices", "accessibilityId");
        if (freeDevices.size() != 0) {
            return getText(freeDevice, "get Free Device Name ");
        }

        return null;

    }

    public void verifyHomeName() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(RegionMarketFilter);
        Thread.sleep(1000);
        System.out.println("homeName " + homeName);
        String homeNameAfterFilter = getHomeName();
        sa.assertNotEquals(homeName, homeNameAfterFilter);
        homeName = homeNameAfterFilter;
        sa.assertAll();

    }

    public void verifyFreeDeviceName() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        waitForVisibility(RegionMarketFilter);
        Thread.sleep(1000);
        System.out.println("freeDeviceName " + freeDeviceName);
        String freeDeviceNameAfterFilter = getFreeDeviceName();
        sa.assertNotEquals(freeDeviceName, freeDeviceNameAfterFilter);
        freeDeviceName = freeDeviceNameAfterFilter;
        sa.assertAll();

    }

    public void selectRegionOrMarket(int index) throws InterruptedException {
        Thread.sleep(1000);
        List<MobileElement> elements = getElements("android.widget.CheckedTextView", "className");
        click(elements.get(index));
        Thread.sleep(1000);
    }

    public void clickOnRegionOrMarket(String selector) throws InterruptedException {
        Thread.sleep(1000);
        List<MobileElement> elements = getElements("android.widget.EditText", "className");
        if (elements.size() > 0) {
            switch (selector) {
                case "region": {
                    click(elements.get(0));
                    break;
                }
                case "market": {
                    click(elements.get(1));
                    break;
                }
            }
        }
    }

    public void RegionAndMarketFilter(boolean isFreeDevices) throws InterruptedException {
        if (isFreeDevices) {
            clickOnFreeDevices();
        }
        Thread.sleep(5000);
        hideKeyboard();
        clickOnFilter();
        clickOnRegionOrMarket("region");
        int regions = getTotalCountOfRegionsOrMarkets();
        selectRegionOrMarket(0);
        int markets;
        for (int i = 0; i < regions; i++) {
            if (i != 0) {
                clickOnFilter();
                clickOnRegionOrMarket("region");
                selectRegionOrMarket(i);
            }
            clickOnRegionOrMarket("market");
            markets = getTotalCountOfRegionsOrMarkets();
            if (markets > 0) {
                for (int j = 0; j < markets; j++) {
                    selectRegionOrMarket(j);
                    if (j != markets - 1) {
                        applyFilter();
                        if (isFreeDevices) {
                            verifyFreeDeviceName();
                        } else {
                            verifyHomeName();
                        }
                        clickOnFilter();
                        clickOnRegionOrMarket("market");
                    }

                }
            } else {
                applyFilter();
                if (isFreeDevices) {
                    verifyFreeDeviceName();
                } else {
                    verifyHomeName();
                }
            }

        }

    }

}
