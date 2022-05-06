package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setup()
    {
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void navigateToContact() throws InterruptedException {
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
        driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
        driver.findElement(By.xpath("//*[@id='post-24042']/div[2]/p[2]/a")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Effective Writing & Promoting Your Content')]")).click();

        String devStrategyPageTitle = driver.getTitle();
        Assert.assertEquals(devStrategyPageTitle,"Effective Writing & Promoting Your Content – Alchemy LMS");

        driver.findElement(By.xpath("//*[@id='learndash_post_283']/div/div[3]/div[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//a/div[contains(text(),'The Power Of Effective Content')]")).click();
        WebElement markComplete = driver.findElement(By.xpath("//*[@id=\"learndash_post_24183\"]/div/div[3]/div[2]/form/input[4]"));
        if(markComplete != null) {
            markComplete.click();
        }
        else{
            System.out.println("Mark complete button does not exists,you may have completed the course");
        }
    }


    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
