package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity1 {

    AndroidDriver<MobileElement> driver;

   @BeforeClass
    public void setUp() throws MalformedURLException {

       //DesiredCapabilities
       //Driver takes two arguments
       DesiredCapabilities cap = new DesiredCapabilities();
       cap.setCapability("platformName","android");
       cap.setCapability("automationName","UiAutomator2");
       cap.setCapability("deviceName","Pixel4Emulator");

       //Action section on insector
       cap.setCapability("appPackage","com.android.calculator2");
       cap.setCapability("appActivity",".Calculator");

       //Do not reset the applications opened on phone
       cap.setCapability("noReset","true");

       //Appium server url
       URL serverURL = new URL("http://localhost:4723/wd/hub");
       driver = new AndroidDriver(serverURL,cap);

    }

    @Test
    public void multiply(){
        MobileElement digit1 = driver.findElementById("digit_8");
        digit1.click();

        MobileElement multi = driver.findElementById("op_mul");
        multi.click();

        MobileElement digit2 = driver.findElementById("digit_5");
        digit2.click();

        MobileElement equals = driver.findElementByAccessibilityId("equals");

        String results = driver.findElementById("result").getText();
        int res =Integer.parseInt(results);
        Assert.assertEquals(res,40);
    }


    @AfterClass
    public void teardown(){
       driver.quit();
    }
}
