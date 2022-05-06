package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup(){
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void verifyHeadingOfSecondPopularCourse(){
        String headingOfSecondPopularCourse= driver.findElement(By.xpath("//article[@id='post-71']/div[@class='caption']/h3")).getText();
        Assert.assertEquals(headingOfSecondPopularCourse,"Email Marketing Strategies");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
