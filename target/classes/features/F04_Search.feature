@smoke
Feature: F04_Search | users could use search functionality for products
  Scenario: user could search using product name
    Given user could login to his account
    When user could search using product name
    Then user could found product successfully

  Scenario Outline: user could search for product using sku
    Given user could login to his account
    When user could search for product using "<sku>"
    Then user could found specific product successfully
    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|