package examples;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnExample {



    @Test(dependsOnMethods = { "OpenBrowser" })
    public void SignIn() {
        System.out.println("This will execute second (SignIn)");
    }

    @Test
    public void OpenBrowser() {
        System.out.println("This will execute first (Open Browser)");
    }

    @Test (dependsOnMethods = { "SignIn" })
    public void LogOut() {
        System.out.println("This will execute third (Log Out)");
    }
}
