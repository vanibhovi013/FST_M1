package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class Activity1 {

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
        cap.setCapability("appPackage","com.google.android.apps.tasks");
        cap.setCapability("appActivity",".ui.TaskListsActivity");

        //Do not reset the applications opened on phone
        cap.setCapability("noReset","true");

        //Appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,cap);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void addNewTaskToGoogleTask(){
        MobileElement newTaskButton = driver.findElementById("tasks_fab");
        newTaskButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        MobileElement newTaskText1= driver.findElementById("add_task_title");
        newTaskText1.sendKeys("Complete Activity with Google Tasks");

        MobileElement saveButton1 = driver.findElementById("add_task_done");
        saveButton1.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        newTaskButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        MobileElement newTaskText2= driver.findElementById("add_task_title");
        newTaskText2.sendKeys("Complete Activity with Google Keep");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
        MobileElement saveButton2 = driver.findElementById("add_task_done");
        saveButton2.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        newTaskButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        MobileElement newTaskText3= driver.findElementById("add_task_title");
        newTaskText3.sendKeys("Complete the second Activity Google Keep");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
        MobileElement saveButton3 = driver.findElementById("add_task_done");
        saveButton3.click();



        List<MobileElement> listOfElements=driver.findElements(By.id("com.google.android.apps.tasks:id/task_name"));
        for(MobileElement element: listOfElements){
            String addedTask=element.getText();

            if(addedTask.equals("Complete Activity with Google Keep")) {
                Assert.assertEquals(addedTask, "Complete Activity with Google Keep");
            }
            else if(addedTask.equals("Complete Activity with Google Tasks")){
                    Assert.assertEquals(addedTask,"Complete Activity with Google Tasks");
                }
                else if(addedTask.equals("Complete the second Activity Google Keep"))
                {
                    Assert.assertEquals(addedTask, "Complete the second Activity Google Keep");
                }
        }

    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
