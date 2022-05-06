package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup(){
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void verifyHeadingOfFirstInfoBox(){
        String headingOfFirstInfoBox = driver.findElement(By.xpath("//div/following-sibling::div/h3[1]")).getText();
        Assert.assertEquals(headingOfFirstInfoBox,"Actionable Training");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
