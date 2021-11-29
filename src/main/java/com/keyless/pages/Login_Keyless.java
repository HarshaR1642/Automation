package com.keyless.pages;

import com.keyless.AccountTab.UserGuide;
import com.keylessQE.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Login_Keyless extends BaseTest {

//	public GetJSN json =null;
//	public Login_Keyless(){
//	json = new GetJSN("/Users/rakesh/git/Mobile_Automation/keyless/src/test/resources/Element_Id/login.json");
//	}

    @AndroidFindBy(accessibility = "residentLogin")
    @iOSXCUITFindBy(accessibility = "residentLogin")
    private MobileElement LoginResident;

    @AndroidFindBy(accessibility = "managerLogin")
    @iOSXCUITFindBy(accessibility = "managerLogin")
    private MobileElement LoginManager;

    @AndroidFindBy(accessibility = "email")
    @iOSXCUITFindBy(accessibility = "email")
    private MobileElement Enteruserid;

    @AndroidFindBy(accessibility = "password")
    @iOSXCUITFindBy(accessibility = "password")
    private MobileElement EnterPassword;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='EMAIL']")
    private MobileElement tapoutside;

    @AndroidFindBy(accessibility = "login")
    @iOSXCUITFindBy(accessibility = "login")
    private MobileElement LoginBtn;

    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(id = "Username or password is incorrect.")
    private MobileElement errtxt;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(id = "Ok")
    private MobileElement OKbtn;


    @AndroidFindBy(accessibility = "searchPlaceHolder")
    @iOSXCUITFindBy(accessibility = "searchPlaceHolder")
    private MobileElement search;


    public Login_Keyless taponLoginAsResident() {
        System.out.println("Select Login as Resident Button");
        click(LoginResident, "Press Login as resident Button");
        return this;

    }

    public Select_Home taponLoginAsManager() {
        System.out.println("Select Login as Resident Button");
        click(LoginManager, "Press Login as resident Button");
        return new Select_Home();
    }


    public Select_Home taponLoginAsResident1() {
        System.out.println("Select Login as Resident Button");
        click(LoginResident, "Select Login as Resident Button");
        return new Select_Home();

    }

    public Thermostat taponLoginAsResident3() {
        System.out.println("Select Login as Resident Button");
        click(LoginResident, "Select Login as Resident Button");
        return new Thermostat();

    }


    public Login_Keyless enterEmail(String username) {
        clear(Enteruserid);
        System.out.println("Enter User Id :" + username);
        sendKeys(Enteruserid, username, "Enter User Id :" + username);
        return this;
    }


    public Login_Keyless cleartxtbox() {
        Enteruserid.clear();
        return this;
    }

    public Login_Keyless enterpassword(String password) {
        clear(EnterPassword);
        System.out.println("Enter Password :" + password);
        sendKeys(EnterPassword, password, "Enter Password :" + password);
        hideKeyboard();
        return this;
    }

    public Login_Keyless tapoutsides() {
        click(tapoutside);
        return this;
    }

    public UserGuide taponLoginBtn() {
        click(LoginBtn, "Tap on Login button");
        System.out.println("Tap on Login button");
        return new UserGuide();
    }

    public Select_Home taponLoginBtn1() {
        click(LoginBtn);
        System.out.println("Tap on Login button");
        return new Select_Home();
    }

    public Thermostat taponLoginBtn2() {
        click(LoginBtn);
        System.out.println("Tap on Login button");
        return new Thermostat();
    }

    public Select_Home LoginBtn_tap() {
        click(LoginBtn);
        System.out.println("Tap on Login button");
        return new Select_Home();
    }


    public UserGuide login(String username, String password) {
        enterEmail(username);
        enterpassword(password);
        return taponLoginBtn();

    }

    public Select_Home login_1(String username, String password) {
        enterEmail(username);
        enterpassword(password);
        return taponLoginBtn1();

    }

    public Thermostat login_2(String username, String password) {
        enterEmail(username);
        enterpassword(password);
        return taponLoginBtn2();

    }

    public Login_Keyless switchtoalert() {
        switchAlert(errtxt);
        return this;
    }


    public String getErrTxt() {
        String errTxt = getText(errtxt, "Login error pop up text is -");
        System.out.println("Improper login credentials alert  -" + errtxt);
        return errTxt;

    }


    public Login_Keyless ErrOKbtn() {
        click(OKbtn);
        return this;
    }

    public UserGuide taponLoginAsResident2() {
        click(LoginResident, "Select Login as Resident Button");
        return new UserGuide();
    }

    public void search(String value) {
        sendKeys(search, value);

    }


}
