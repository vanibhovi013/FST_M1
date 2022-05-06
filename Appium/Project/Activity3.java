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

public class Activity3 {
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
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));

        driver.findElementByAccessibilityId("To-Do List \uF0AE Elements get added at run time").click();

        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput")));
        //driver.findElementById("taskInput").sendKeys("Add tasks to list");;
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        MobileElement textField = driver.findElement(By.className("android.widget.EditText"));
        //textField.click();
        textField.sendKeys("Add tasks to list");
        driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Add Task')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        textField = driver.findElement(By.className("android.widget.EditText"));
        //textField.click();
        textField.sendKeys("Get number of tasks");
        driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Add Task')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        textField = driver.findElement(By.className("android.widget.EditText"));
        //textField.click();
        textField.sendKeys("Clear the list");
        driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Add Task')]")).click();

        MobileElement strike1 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Add tasks to list')]"));
        strike1.click();

        MobileElement strike2 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Get number of tasks')]"));
        strike2.click();

        MobileElement strike3 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Clear the list')]"));
        strike3.click();
        driver.findElementByClassName("android.view.View").click();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
