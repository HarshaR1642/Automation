package com.keylessQE.test.Devices;

import com.keyless.Devices.Thermostat;
import com.keyless.Devices.ThermostatSchedule;
import com.keyless.pages.Login_Keyless;
import com.keyless.pages.Select_Home;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ThermostatTest {

    JSONObject loginusers;
    Thermostat thermostat;
    ThermostatSchedule thermostatSchedule;
    Select_Home selectHome;
    Login_Keyless loginpage;

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
        thermostat = new Thermostat();
        thermostatSchedule = new ThermostatSchedule();
        selectHome = new Select_Home();
        System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");

    }


//    @Test(priority = 40)
//    public void ThermostatTest1() throws Exception {
//        thermostat.navigateToThermostatDevice();
//        thermostat.changeOperatingModeAutomatically();
//        thermostat.changeTemperature();
//        String time = thermostat.clickSaveButton();
//        thermostat.checkActivity(time);
//    }
//
//    @Test(priority = 41)
//    public void ThermostatTest2() throws Exception {
//        thermostat.changeOperatingModeAutomatically();
//        thermostat.changeTemperature();
//        String time = thermostat.clickSaveButton();
//        thermostat.checkActivity(time);
//    }
//	
//	@Test(priority=42)
//	public void ThermostatTest3() throws Exception
//	{
//		thermostat.changeOperatingModeAutomatically();
//		thermostat.changeTemperature();
//		String time = thermostat.clickSaveButton();
//		thermostat.checkActivity(time);
//	}
//	
//	@Test(priority=43)
//	public void ThermostatTest4() throws Exception
//	{
//		thermostat.changeOperatingModeAutomatically();
//		thermostat.changeTemperature();
//		String time = thermostat.clickSaveButton();
//		thermostat.checkActivity(time);
//		thermostat.clickOnFanModeButton();
//		thermostat.changeFanMode();
//	}

    @Test(priority = 44)
    public void ThermostatScheduleTest() throws Exception {
        thermostat.navigateToThermostatDevice();
        thermostatSchedule.clickOnThermostatScheduleTab();
        thermostatSchedule.clickOnEnableDisableSchedule();
        thermostatSchedule.addSchedule();
        thermostatSchedule.selectSchedulerTime();
        thermostatSchedule.verifySelectedTime();
        thermostatSchedule.selectSchedulerTime();
        thermostatSchedule.selectAutoModeForScheduler();
        thermostatSchedule.selectOffModeForScheduler();
        //thermostatSchedule.selectHeatModeForScheduler();
        //thermostatSchedule.selectCoolModeForScheduler();
        thermostatSchedule.deleteSchedule();
        thermostatSchedule.undoEntry();
    }

}

