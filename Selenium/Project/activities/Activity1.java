package activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setup(){
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void verifyTitleOfWebSite(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Alchemy LMS – An LMS Application");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
