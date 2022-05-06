package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(){
    System.out.println("This will run before the every Scenario");
}

    @After
    public void afterScenario(){
        System.out.println("This will run after the every Scenario");
    }

    @Before("@First or @Third")
    public void beforeFirst(){
        System.out.println("This will run only before the First Scenario and Third Scenario");
    }

    @After("@First or @Second")
    public void afterFirst(){
        System.out.println("This will run only after the First Scenario and Second Scenario");
    }
}
