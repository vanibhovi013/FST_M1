package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity5 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //DesiredCapabilities
        //Driver takes two arguments
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("deviceName","Pixel4Emulator");

        //Action section on inspector
        cap.setCapability("appPackage","com.android.chrome");
        cap.setCapability("appActivity","com.google.android.apps.chrome.Main");

        //Do not reset the applications opened on phone
        cap.setCapability("noReset","true");

        //Appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,cap);
        wait = new WebDriverWait(driver, 50);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @Test
    public void testToDOListOnChrome() throws InterruptedException {
        driver.get("https://www.training-support.net/selenium");

       // wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("")));

        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(9)"));

        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Tooltips and Modals')]")).click();



    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
