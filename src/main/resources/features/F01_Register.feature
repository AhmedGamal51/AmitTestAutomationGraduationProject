@smoke
Feature: F01_Register | user can create new account
#    Background :i navigate to the register page


  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user enter valid credentials
    Then success message is displayed