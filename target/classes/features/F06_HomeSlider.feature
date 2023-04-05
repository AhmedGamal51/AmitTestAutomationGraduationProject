@smoke
Feature: F06_HomeSlider | user could use the functionality of homeSlider
  Scenario: first slider is clickable on home page
    Given user could access his account
    When user could click on "iphone"
    Then check the current "iphone"
  Scenario: second slider is clickable on home page
    Given user could access his account
    When user could click on "samsung"
    Then check the current "samsung"