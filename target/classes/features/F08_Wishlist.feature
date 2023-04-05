@smoke
Feature: F08_Wishlist.feature | users could use wishlist functionality from their accounts
  Scenario: users could use wishlist button from their accounts
    Given user could access his account
    When user click on wishlist button
    Then check wishlist functionality
  Scenario: users could check wishlist link from their accounts
    Given user could access his account
    When user click on wishlist link
    Then check wishlist link functionality