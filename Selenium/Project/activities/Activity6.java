package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity6 {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup()
    {
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void navigateToMyAccountAndLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"My Account – Alchemy LMS");
        //Login using credentials
        driver.findElement(By.xpath("//div[@class='learndash-wrapper']/a")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        String getuserName = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a/span")).getText();
        Assert.assertEquals(getuserName,"root");

    }


    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
