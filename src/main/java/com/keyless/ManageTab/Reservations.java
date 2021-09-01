package com.keyless.ManageTab;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;

public class Reservations extends BaseTest {

    @AndroidFindBy(accessibility = "MANAGE_TAB")
    @iOSXCUITFindBy(accessibility = "MANAGE_TAB")
    private MobileElement manageTab;

    @AndroidFindBy(accessibility = "reservations")
    @iOSXCUITFindBy(accessibility = "reservations")
    private MobileElement reservations;

    @AndroidFindBy(accessibility = "managerHome")
    @iOSXCUITFindBy(accessibility = "managerHome")
    private MobileElement managerHome;

    @AndroidFindBy(accessibility = "createReservation")
    @iOSXCUITFindBy(accessibility = "createReservation")
    private MobileElement createReservation;

    @AndroidFindBy(accessibility = "reservationName")
    @iOSXCUITFindBy(accessibility = "reservationName")
    private MobileElement reservationName;

    @AndroidFindBy(accessibility = "propertyList")
    @iOSXCUITFindBy(accessibility = "propertyList")
    private MobileElement propertyList;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "close")
    private MobileElement close;

    @AndroidFindBy(accessibility = "done")
    @iOSXCUITFindBy(accessibility = "done")
    private MobileElement done;

    @AndroidFindBy(accessibility = "code")
    @iOSXCUITFindBy(accessibility = "code")
    private MobileElement code;

    @AndroidFindBy(accessibility = "generateRandomCode")
    @iOSXCUITFindBy(accessibility = "generateRandomCode")
    private MobileElement generateRandomCode;

    @AndroidFindBy(accessibility = "fromTime")
    @iOSXCUITFindBy(accessibility = "fromTime")
    private MobileElement fromTime;

    @AndroidFindBy(accessibility = "toTime")
    @iOSXCUITFindBy(accessibility = "toTime")
    private MobileElement toTime;

    @AndroidFindBy(accessibility = "reservationId")
    @iOSXCUITFindBy(accessibility = "reservationId")
    private MobileElement reservationId;

    @AndroidFindBy(accessibility = "save")
    @iOSXCUITFindBy(accessibility = "save")
    private MobileElement save;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Yes")
    private MobileElement ok;


    private final String checkBoxPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup";




    public void clickOnManageTab() {
        click(manageTab, "Tap on the Manage Tab");
    }

    public void selectAsset(int index) {
        try {
            waitForVisibility(managerHome);
        }catch (Exception e){
            System.out.println("Asset List is empty");
        }
        List<MobileElement> assets = getElements("managerHome", "accessibilityId");
        click(assets.get(index));
    }

    public void clickOnReservations() {
        try{
            Thread.sleep(2000);
            click(reservations, "Tap on Reservations");
        }catch (Exception ignored){

        }
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public boolean selectProperty() {
        try{
            waitForVisibility(done);
            List<MobileElement> properties = getElements(checkBoxPath, "xPath");
            if(properties.size() == 0){
                return false;
            }
            if(properties.size() == 1) {
                click(properties.get(0));
            }else {
                click(properties.get(0));
                click(properties.get(1));
            }
            click(done);
        }catch (Exception ignored){
            System.out.println("No Properties to select");
            return false;
        }
        return true;
    }

    public void createReservation(String name) {
        click(createReservation);
        sendKeys(reservationName,name);
        click(propertyList);
        boolean isPropertySelected = selectProperty();
        if(!isPropertySelected){
            return;
        }
        sendKeys(code,"123456");
        click(generateRandomCode);
        // todo :add scroll
        click(fromTime);
        click(ok);
        click(ok);
        click(toTime);
        click(ok);
        click(ok);
        sendKeys(reservationId,"1729");
        hideKeyboard();
        click(save);
        click(ok);


    }


}
