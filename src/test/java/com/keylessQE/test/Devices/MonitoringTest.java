package com.keylessQE.test.Devices;
import com.keyless.Devices.Monitoring;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MonitoringTest {

    JSONObject loginusers;
    Monitoring monitoring;

    @BeforeClass
    public void beforeClass() throws IOException {

        InputStream datails = null;
        try {
            String dataFileName = "Data/Loginuser.json";
            datails = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datails);
            loginusers = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datails != null) {
                datails.close();
            }
        }


    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        monitoring = new Monitoring();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }

    @Test
    public void monitoringTest1() throws Exception {
        Thread.sleep(1000);
        monitoring.navigateToMonitoringCard();
        String time = null;
        if (monitoring.getState().equals("armed")) {
            time = monitoring.clickToDisarm();
            monitoring.clickOnMonitoringActivityTab();
            monitoring.checkActivity("disarmed", time);
            monitoring.clickOnMonitoringDetailsTab();
        } else {
            time = monitoring.clickToArm();
            monitoring.clickOnMonitoringActivityTab();
            monitoring.checkActivity("armed", time);
            monitoring.clickOnMonitoringDetailsTab();
        }
    }

    @Test
    public void monitoringTest2() throws Exception {
        Thread.sleep(1000);
        String time = null;
        if (monitoring.getState().equals("armed")) {
            time = monitoring.clickToDisarm();
            monitoring.clickOnMonitoringActivityTab();
            monitoring.checkActivity("disarmed", time);
            monitoring.clickOnMonitoringDetailsTab();
        } else {
            time = monitoring.clickToArm();
            monitoring.clickOnMonitoringActivityTab();
            monitoring.checkActivity("armed", time);
            monitoring.clickOnMonitoringDetailsTab();
        }
    }

    @Test
    public void monitoringScheduleTest() throws Exception {
        //monitoring.navigateToMonitoringCard();
        monitoring.clickOnScheduleTab();
        monitoring.clickOnEnableDisableSchedule();
        monitoring.deleteSchedule();
        monitoring.addSchedule();
        monitoring.selectSchedulerTime();
        monitoring.verifySelectedTime();
        monitoring.selectSchedulerTime();
        monitoring.selectArmModeForScheduler();
        monitoring.selectDisarmModeForScheduler();
        monitoring.deleteSchedule();
        monitoring.undoEntry();
    }


}

