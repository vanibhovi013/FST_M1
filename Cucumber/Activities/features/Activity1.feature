@activity1
Feature: First Test

  @activity1
  Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
    When User types in Cheese and hits ENTER
    Then Show how many search results were shown
    And Close the Browser