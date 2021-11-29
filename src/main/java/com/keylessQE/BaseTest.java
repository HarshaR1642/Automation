package com.keylessQE;

import com.aventstack.extentreports.Status;
import com.keyless.utils.testUtils;
import com.qe_Keyless.reports.ExtentReport;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class BaseTest {

    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
    protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    protected static ThreadLocal<String> platform = new ThreadLocal<String>();
    protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();
    static Logger log = LogManager.getLogger(BaseTest.class.getName());
    public ThreadLocal<AppiumDriver<MobileElement>> mobileThreadLocal = new ThreadLocal<AppiumDriver<MobileElement>>();
    //testUtils utils;
    testUtils utils = new testUtils();

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public Properties getProps() {
        return props.get();
    }

    public void setProps(Properties props2) {
        props.set(props2);
    }

    public HashMap<String, String> getStrings() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }

    @BeforeMethod
    public void beforeMethod() {
        ((CanRecordScreen) getDriver()).startRecordingScreen();
    }


    @AfterMethod
    public synchronized void afterMethod(ITestResult result) throws Exception {
        String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();

        if (result.getStatus() == 2) {
            Map<String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
            String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName")
                    + File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();

            File videoDir = new File(dirPath);

            synchronized (videoDir) {
                if (!videoDir.exists()) {
                    videoDir.mkdirs();
                }
            }

            try {
                FileOutputStream stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
                stream.write(Base64.decodeBase64(media));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


    //"systemPort",@Optional("androidOnly") String systemPort,

    @Parameters({"platformName", "deviceName", "udid", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeTest
    public void beforeTest(String platformName, String deviceName, String udid, @Optional("androidOnly") String systemPort,
                           @Optional("androidOnly") String chromeDriverPort, @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort) throws Exception {
        utils = new testUtils();
        setDateTime(utils.dateTime());
        setPlatform(platformName);
        //URL url;
        Properties props = new Properties();
        InputStream stringsis = null;
        InputStream inputstream = null;
        AppiumDriver driver;

        String strFile = "logs" + File.separator + platformName + "_" + deviceName;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        ThreadContext.put("ROUTINGKEY", strFile);


        try {
            props = new Properties();
            String propfileName = "config.properties";
            String xmlFileName = "strings/strings.xml";

            inputstream = getClass().getClassLoader().getResourceAsStream(propfileName);
            props.load(inputstream);
            setProps(props);
            stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
            utils = new testUtils();
            setStrings(utils.parseStringXML(stringsis));

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", platformName);
            //desiredCapabilities.setCapability("platformVersion", platformVersion);
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("udid", udid);
            URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
            URL url2 = new URL("http://127.0.0.1:4724/wd/hub");


            switch (platformName) {
                case "Android":
                    desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
                    desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    desiredCapabilities.setCapability("skipDeviceInitialization", props.getProperty("skipDeviceInitialization"));
                    desiredCapabilities.setCapability("skipDeviceInitialization", props.getProperty("skipServerInstallation"));
                    desiredCapabilities.setCapability("systemPort", systemPort);
                    desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
                    desiredCapabilities.setCapability("automationName", "UiAutomator2");
                    desiredCapabilities.setCapability("dontStopAppOnReset", true);


                    //URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
                    desiredCapabilities.setCapability("app", "/Users/rentlycoimbatore/Desktop/swift/app-flavorDefault-release.apk");

                    //desiredCapabilities.setCapability("app","/Users/rentlycoimbatore/Desktop/bluebuild/app-flavorDefault-release.apk");

                    //driver =new AndroidDriver(url1, desiredCapabilities);
                    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                    break;

                case "iOS":

                    desiredCapabilities.setCapability("platformName", "iOS");
                    desiredCapabilities.setCapability("platformVersion", "14.0");
                    desiredCapabilities.setCapability("automationName", "XCUITest");
                    desiredCapabilities.setCapability("udid", "17EC789A-D752-4395-A9CA-D008A9333C8A");
                    desiredCapabilities.setCapability("deviceName", "iPhone 11");
                    desiredCapabilities.setCapability("unicodeKeyboard", true);
                    desiredCapabilities.setCapability("resetKeyboard", true);
                    desiredCapabilities.setCapability("noReset", false);
                    desiredCapabilities.setCapability("autoGrantPermissions", true);
                    desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
                    desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
                    desiredCapabilities.setCapability("dontStopAppOnReset", true);


                    desiredCapabilities.setCapability("app", "/Users/rentlycoimbatore/Library/Developer/Xcode/DerivedData/keyless-gibtfofxvofnasffajoxjcjxctvw/Build/Products/Debug-iphonesimulator/keyless.app");


                    //desiredCapabilities.setCapability("bundleId", "com.smart.rently");
                    //desiredCapabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, 8200);
                    //desiredCapabilities.setCapability("app", iOSAppUrl);
                    //driver = new IOSDriver(url2, desiredCapabilities);
                    driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                    break;

                default:
                    throw new Exception("Invalid platform! - " + platformName);


            }


            setDriver(driver);

            String sessionId = driver.getSessionId().toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputstream != null) {
                inputstream.close();
            }
            if (stringsis != null) {
                stringsis.close();

            }

        }

    }

    public void waitforvisbility(MobileElement e, int wait) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), wait);
        wait1.until(ExpectedConditions.visibilityOf(e));
    }

    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public boolean isIOS() {
        return getPlatform().equals("iOS");
    }

    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), testUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibilityOfElementWithText(MobileElement e, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), testUtils.WAIT);
        wait.until(ExpectedConditions.textToBePresentInElement(e, text));
    }

    public void hideKeyboard() {
        getDriver().hideKeyboard();

    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();

    }

    public void click(MobileElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        ExtentReport.getTest().log(Status.INFO, msg);
        e.click();
    }

    public void clickOnDeviceCard(MobileElement e, String message) {
        if (getPlatform().equals("iOS")) {
            int x = e.getLocation().getX() + (e.getSize().width / 4);
            int y = e.getLocation().getY() + (e.getSize().height / 2);
            ExtentReport.getTest().log(Status.INFO, message);
            new TouchAction<>((PerformsTouchActions) getDriver())
                    .press(PointOption.point(x, y))
                    .release()
                    .perform();
        } else {
            click(e);
        }
    }

    public List<MobileElement> getElements(String element, String selector) {
        switch (selector) {
            case "accessibilityId": {
                return getDriver().findElementsByAccessibilityId(element);
            }
            case "className": {
                return getDriver().findElementsByClassName(element);
            }
            case "xPath": {
                return getDriver().findElementsByXPath(element);
            }
            case "id": {
                return getDriver().findElementsById(element);
            }
            default: {
                return null;
            }

        }

    }


    public void switchAlert(MobileElement e) {

        getDriver().switchTo().alert();
    }


    public String getTime(int seconds) {
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, seconds);
        long utc = date.getTime() - calendar.get(calendar.ZONE_OFFSET);
        Date time = new Date(utc + 3600000 * -7 + seconds * 1000);
        ExtentReport.getTest().log(Status.INFO, "Time of Operation: " + (parseFormat.format(time)));
        return parseFormat.format(time);
    }

    public void getTime(MobileElement e, int txt) {
        waitForVisibility(e);

    }


    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.clear();
        e.sendKeys(txt);
    }

    public void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        ExtentReport.getTest().log(Status.INFO, msg);
        e.clear();
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt = null;
        switch (getPlatform()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
        }
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg);
        return txt;
    }

    public String getTextByIndex(int index) {
        String className;
        if (getPlatform().equals("iOS")) {
            className = "XCUIElementTypeStaticText";
        } else {
            className = "android.widget.TextView";
        }
        List<MobileElement> textElements = getDriver().findElements(By.className(className));
        String text = getText(textElements.get(index), "");
        ExtentReport.getTest().log(Status.INFO, text);

        return text;

    }

    public void swipeWithElements(MobileElement press, MobileElement moveTo, String message) {
        waitForVisibility(press);
        waitForVisibility(moveTo);
        ExtentReport.getTest().log(Status.INFO, message);
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(ElementOption.element(press))
                .moveTo(ElementOption.element(moveTo))
                .release()
                .perform();
        ExtentReport.getTest().log(Status.INFO, "Swipe Successful");

    }

    public boolean scroll(int startx, int starty, int endx, int endy) {

        String pageSourceBeforeScroll = getDriver().getPageSource();
        new TouchAction<>(getDriver())
                .longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();
        return pageSourceBeforeScroll.equals(getDriver().getPageSource());

    }

    public void scrollToElement(String element, String selector, int startX, int startY, int endX, int endY) {
        SoftAssert sa = new SoftAssert();
        String pageSourceBeforeScroll = getDriver().getPageSource();
        String pageSourceAfterScroll;
        while (getElements(element, selector).size() == 0) {
            scroll(startX, startY, endX, endY);
            pageSourceAfterScroll = getDriver().getPageSource();
            if(pageSourceBeforeScroll.equals(pageSourceAfterScroll)){
                System.out.println("Element Not Found in the UI");
                sa.assertTrue(false,"Element Not Found in the UI");
                sa.assertAll();
                return;
            }else {
                pageSourceBeforeScroll = pageSourceAfterScroll;
            }
        }
    }


    public void swipeRight(MobileElement e) {

        //The viewing size of the device
        Dimension size = getDriver().manage().window().getSize();

        //Starting x location set to 5% of the width (near left)
        int startx = (int) (size.width * 0.95);
        //Ending x location set to 95% of the width (near right)
        int endx = (int) (size.width * 0.05);
        //y position set to mid-screen vertically
        int starty = size.height / 2;

        scroll(startx, starty, endx, starty);

    }

    public void swipeLeft(MobileElement e) {

        //The viewing size of the device
        Dimension size = getDriver().manage().window().getSize();

        //Starting x location set to 5% of the width (near left)
        int startx = (int) (size.width * 0.95);
        //Ending x location set to 95% of the width (near right)
        int endx = (int) (size.width * 0.05);
        //y position set to mid-screen vertically
        int starty = size.height / 2;

        scroll(startx, starty, endx, starty);

    }


    public void Freez_App_For_Seconds(int seconds) {
        try {
            for (int i = seconds; i >= 1; i--) {
                Thread.sleep(1000);
                System.out.println("Resuming app in " + i + " seconds(s) ...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swipeVertical(MobileElement element) {
        Point location = element.getLocation();
        //Dimension size = getMobileDriver().manage().window().getSize();
        System.out.println(location);

        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (location.getX() * 0.90);
        //Find endx point which is at left side of screen.
        int endx = (int) (location.getX() * 0.10);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = (int) (location.getY() * 0.10);
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(PointOption.point(starty, endx))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(starty, startx))
                .release().perform();

        Freez_App_For_Seconds(5);
    }

    public void Allow_App_Permission() {
        while (getDriver().findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size() > 0) {
            getDriver().findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
        }
    }


    public void closeApp() {
        ((InteractsWithApps) getDriver()).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) getDriver()).launchApp();
    }

    @AfterSuite
    public void afterTest() {
        getDriver().quit();
    }


}
