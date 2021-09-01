package com.keyless.AccountTab;

import com.keyless.pages.Select_Home;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class UserGuide extends BaseTest {


    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ACCESS HOME LIST']")
    @iOSXCUITFindBy(id = "ACCESS HOME LIST")
    private MobileElement AccessHomeList_1st;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Select home to view and control your devices in the dashboard']")
    @iOSXCUITFindBy(id = "iOS")
    private MobileElement AccessHomeList_1stDescrpt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='UNLOCK STATUS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='UNLOCK STATUS']")
    private MobileElement AccessHomeList_2nd;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Swipe right to lock']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Swipe right to lock']")
    private MobileElement AccessHomeList_2ndDescrpt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='LOCK STATUS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOCK STATUS']")
    private MobileElement AccessHomeList_3rd;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Swipe left to unlock']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Swipe left to unlock']")
    private MobileElement AccessHomeList_3rdDescrpt;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='SETTING THERMOSTAT POINTS'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SETTING THERMOSTAT POINTS'])[1]")
    private MobileElement AccessHomeList_4th;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Slide to set the heating point temperature']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Slide to set the heating point temperature']")
    private MobileElement AccessHomeList_4thDescrpt;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='SETTING THERMOSTAT POINTS'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SETTING THERMOSTAT POINTS'])[2]")
    private MobileElement AccessHomeList_5th;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Slide to set the cooling point temperature']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Slide to set the cooling point temperature']")
    private MobileElement AccessHomeList_5thDescrpt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='THERMOSTAT DETAILS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='THERMOSTAT DETAILS']")
    private MobileElement AccessHomeList_6th;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Touch to see your thermostat details']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Touch to see your thermostat details']")
    private MobileElement AccessHomeList_6thDescrpt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ACCESS SCHEDULE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ACCESS SCHEDULE']")
    private MobileElement AccessHomeList_7th;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Touch to access your schedule']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Touch to access your schedule']")
    private MobileElement AccessHomeList_7thDescrpt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ADD SCHEDULE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD SCHEDULE']")
    private MobileElement AccessHomeList_8th;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Edit or add a new schedule']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit or add a new schedule']")
    private MobileElement AccessHomeList_8thDescrpt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ACCESS DEVICES']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ACCESS DEVICES']")
    private MobileElement AccessHomeList_9th;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Touch to control your devices in dashboard']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Touch to control your devices in dashboard']")
    private MobileElement AccessHomeList_9thDescrpt;


    @AndroidFindBy(accessibility = "next")
    @iOSXCUITFindBy(accessibility = "next")
    private MobileElement Next;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='skipOrDone']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='skipOrDone'])[2]")
    private MobileElement UGDone;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Done")
    private MobileElement PopUpDoneBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='skipOrDone']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='skipOrDone'])[2]")
    private MobileElement DoneBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "You can later check this user guide under the account section.")
    private MobileElement Donepopuptxt;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Done")
    private MobileElement DonepopupClose;

    @AndroidFindBy(accessibility = "skipOrDone")
    @iOSXCUITFindBy(accessibility = "skipOrDone")
    private MobileElement SkipBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "You can later check this user guide under the account section.")
    private MobileElement SkipPopUp;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Skip")
    private MobileElement SkipBtnDone;

    public UserGuide skipUsrGuide() {
        System.out.println("Skip the User Guide");
        waitForVisibility(SkipBtn);
        List<MobileElement> elements = getElements("skipOrDone", "accessibilityId");

        click(elements.get(elements.size() - 1), "Skip the User Guide");
        return this;
    }

    public String SkipPopDescp() {
        System.out.println("Skip pop up desc");
        String description = getText(SkipPopUp, "Text on the skip btn pop up is-");
        System.out.println("Skip pop up text is -" + description);
        return description;
    }

    public UserGuide skipDoneBtn() {
        System.out.println("Skip the User Guide");
        click(SkipBtnDone, "Skip the User Guide");
        return this;
    }

    public Select_Home skipUsrGuide1() {
        System.out.println("Skip the User Guide");
        waitForVisibility(SkipBtn);
        List<MobileElement> elements = getElements("skipOrDone", "accessibilityId");

        click(elements.get(elements.size() - 1), "Skip the User Guide");
        return new Select_Home();
    }

    public Select_Home skipDoneBtn1() {
        System.out.println("Skip the User Guide");
        click(SkipBtnDone, "Skip the User Guide");
        return new Select_Home();
    }


    public String UG1stTitle() {
        System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_1st, "User Guide first page Title is -");
        System.out.println("First user guide Title is -" + title);
        return title;
    }

    public String UG1stDescription() {
        String description = getText(AccessHomeList_1stDescrpt, "User Guide first page Description is -");
        System.out.println("First user guide Description is -" + description);
        return description;
    }

    public String UG2ndTitle() {
        System.out.println(AccessHomeList_2nd);
        String title2 = getText(AccessHomeList_2nd, "User Guide Second page Title is -");
        System.out.println("Second user guide Title is -" + title2);
        return title2;
    }

    public String UG12ndDescription() {
        String description2 = getText(AccessHomeList_2ndDescrpt, "User Guide second page Description is -");
        System.out.println("Second user guide Description is -" + description2);
        return description2;
    }

    public String UG3rdTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_3rd, "User Guide third page Title is -");
        System.out.println("third user guide Title is -" + title);
        return title;
    }

    public String UG13rdDescription() {
        String description = getText(AccessHomeList_3rdDescrpt, "User Guide third page Description is -");
        System.out.println("third user guide Description is -" + description);
        return description;
    }

    public String UG4thTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_4th, "User Guide fourth page Title is -");
        System.out.println("fourth user guide Title is -" + title);
        return title;
    }

    public String UG14thDescription() {
        String description = getText(AccessHomeList_4thDescrpt, "User Guide fourth page Description is -");
        System.out.println("fourth user guide Description is -" + description);
        return description;
    }

    public String UG5thTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_5th, "User Guide fifth page Title is -");
        System.out.println("fifth user guide Title is -" + title);
        return title;
    }

    public String UG15thDescription() {
        String description = getText(AccessHomeList_5thDescrpt, "User Guide fifth page Description is -");
        System.out.println("fifth user guide Description is -" + description);
        return description;
    }

    public String UG6thTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_6th, "User Guide sixth page Title is -");
        System.out.println("sixth user guide Title is -" + title);
        return title;
    }

    public String UG16thDescription() {
        String description = getText(AccessHomeList_6thDescrpt, "User Guide sixth page Description is -");
        System.out.println("sixth user guide Description is -" + description);
        return description;
    }


    public String UG7thTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_7th, "User Guide seventh page Title is -");
        System.out.println("seventh user guide Title is -" + title);
        return title;
    }

    public String UG17thDescription() {
        String description = getText(AccessHomeList_7thDescrpt, "User Guide sevent page Description is -");
        System.out.println("seventh user guide Description is -" + description);
        return description;
    }


    public String UG8thTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_8th, "User Guide eight page Title is -");
        System.out.println("eight user guide Title is -" + title);
        return title;
    }

    public String UG18thDescription() {
        String description = getText(AccessHomeList_8thDescrpt, "User Guide eight page Description is -");
        System.out.println("eight user guide Description is -" + description);
        return description;
    }


    public String UG9thTitle() {
        //System.out.println(AccessHomeList_1st);
        String title = getText(AccessHomeList_9th, "User Guide nine page Title is -");
        System.out.println("ninth user guide Title is -" + title);
        return title;
    }

    public String UG19thDescription() {
        String description = getText(AccessHomeList_9thDescrpt, "User Guide nine page Description is -");
        System.out.println("ninth user guide Description is -" + description);
        return description;
    }


    public UserGuide tapNext() {
        System.out.println("Tap next button.");
        click(Next, "Tap next button.");
        return this;
    }

    public UserGuide tapDone() {
        System.out.println("Complete the user guide now tap on the Done button");
        click(DoneBtn, "User Guide Complete");
        return this;
    }

    public String DoneTxt() {
        System.out.println("User Guide Complete!");
        String donedescription = getText(Donepopuptxt, "Compelte user guide - ");
        System.out.println("After succesfully completing the User guide on tapping the Done button message will be:" + Donepopuptxt);
        return donedescription;
    }


    public Select_Home DonePopupClose() {
        System.out.println("Tap on the Done Button.");
        click(DonepopupClose, "Tap on the Done Button.");
        return new Select_Home();
    }


}
