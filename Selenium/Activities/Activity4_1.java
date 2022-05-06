package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://www.training-support.net");

        String title= driver.getTitle();
        System.out.println(title);

        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();

        //Print title of new page
        System.out.println("New page title is: " + driver.getTitle());

        Thread.sleep(5000);
        //Close the browser
        driver.close();


    }


}
