package com.keylessQE;

import com.keyless.pages.Login_Keyless;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;

public class Runner {

    public ThreadLocal<AppiumDriver<MobileElement>> mobileThreadLocal = new ThreadLocal<AppiumDriver<MobileElement>>();
    AppiumDriverLocalService service;
    AppiumDriver<MobileElement> driver;
    String folder_name;
    Login_Keyless loginpage;
    DateFormat df;
    InputStream datails;
    JSONObject loginusers;

    @Parameters({"deviceName"})
    @BeforeTest
    public void prepareTest(String deviceName) throws IOException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "bijoy@rently.com");
        capabilities.setCapability("pCloudy_ApiKey", "2g9fcttw8cnhfkst9hff4bnt");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
        capabilities.setCapability("pCloudy_DeviceFullName", "MOTOROLA_MotoG7_Android_9.0.0_5105a");
        capabilities.setCapability("platformVersion", "9.0.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("pCloudy_ApplicationName", "app-flavorKairos-release-2.apk");
        capabilities.setCapability("appPackage", "rocks.keyless.app.android.kairos");
        capabilities.setCapability("appActivity", "rocks.keyless.app.android.MainActivity");
        capabilities.setCapability("pCloudy_WildNet", "false");
        capabilities.setCapability("pCloudy_EnableVideo", "false");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
        //AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);

    }


    @Test(priority = 1)
    public void invalidusername() throws Exception {
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='residentLogin']/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='residentLogin']/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='email']")).sendKeys("rs004@mailinator.com");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='password']")).sendKeys("Rakesh88");
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='login']/android.widget.TextView")).click();
    }


}
