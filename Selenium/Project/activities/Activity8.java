package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity8 {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setup()
    {
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void navigateToContact() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
        //Fill the form
        driver.findElement(By.xpath("//div/div/label[contains(text(),'Full Name')]/following-sibling::input")).sendKeys("Nivya");
        driver.findElement(By.xpath("//div/div/label[contains(text(),'Email')]/following-sibling::input")).sendKeys("Nivya@gmail.com");
        driver.findElement(By.xpath("//div/div/label[contains(text(),'Subject')]/following-sibling::input")).sendKeys("Test");
        driver.findElement(By.xpath("//div/div/label[contains(text(),'Comment')]/following-sibling::textarea")).sendKeys("I am testing the app");
        //Submit
        driver.findElement(By.xpath("//div/button[contains(text(),'Send')]")).click();

        String message = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']/p")).getText();
        Assert.assertEquals(message,"Thanks for contacting us! We will be in touch with you shortly.");

    }


    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
