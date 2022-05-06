package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7 {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setup()
    {
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void navigateToAllCourses() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='caption']/h3"));
        System.out.println("There are total " + links.size()+ " Courses");

    }


    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
