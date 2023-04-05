@smoke
Feature: F02_Login | users could use login functionality to use their accounts

  Scenario: user could login with valid email and password
    Given user go to login page
    When user login with valid credentials
    Then user login to the system successfully

  Scenario: user could login with invalid email and password
    Given user go to login page
    When user login with invalid credentials
    Then user could not login to the system