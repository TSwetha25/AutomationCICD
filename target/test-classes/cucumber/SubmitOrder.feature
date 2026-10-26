@tag1
Feature: Purchase the order form Ecommerce Website
 I want to use this template for my feature file

  Background:
    Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test for submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      | name               | password  | productName |
      | swetha25@gmail.com | Swetha@25 | ZARA COAT 3 |
