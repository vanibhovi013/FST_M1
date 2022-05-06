package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity2 {

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
        cap.setCapability("appPackage","com.google.android.keep");
        cap.setCapability("appActivity",".activities.BrowseActivity");

        //Do not reset the applications opened on phone
        cap.setCapability("noReset","true");

        //Appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,cap);
        wait = new WebDriverWait(driver, 50);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

    }

    @Test
    public void addNotesToGoogleKeep() {

        MobileElement addNoteButton = driver.findElement(By.xpath("//android.view.ViewGroup/android.support.v7.widget.RecyclerView"));
        addNoteButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));


        MobileElement noteTitle1 = driver.findElementById("com.google.android.keep:id/editable_title");
        noteTitle1.click();
        noteTitle1.sendKeys("Sample Note");

        MobileElement noteDescription = driver.findElementById("com.google.android.keep:id/edit_note_text");
        noteDescription.click();
        noteDescription.sendKeys("This is my first note for mobile testing");

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.keep:id/index_note_title")));

        String nTitleText = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
        Assert.assertEquals(nTitleText,"Sample Note");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
