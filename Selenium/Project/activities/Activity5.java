package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup(){
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void navigateToMyAccount(){
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
        String headingOFMyAccountPage =  driver.getTitle();
        Assert.assertEquals(headingOFMyAccountPage,"My Account – Alchemy LMS");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
