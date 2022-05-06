package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TagsExample {
    @Given("User opens a page")
    public void user_opens_a_page() {
        System.out.println("Page opened");
    }
    @When("user performs an action")
    public void user_performs_an_action() {
        System.out.println("User performs action");
    }
    @Then("do action for first scenario")
    public void do_action_for_first_scenario() {
        System.out.println("Action for first scenario");
    }

    @Then("do action for second scenario")
    public void do_action_for_second_scenario() {
        System.out.println("Action for second scenario");
    }
    @Then("do action for third scenario")
    public void do_action_for_third_scenario() {
        System.out.println("Action for third scenario");
    }

    @Then("do action for fourth scenario")
    public void do_action_for_fourth_scenario() {
        System.out.println("Action for fourth scenario");
    }


}
