# language: en
@ShoppingCart @Epic-103
Feature: Checkout of a shopping cart
  A user can checkout a shopping cart via the REST API

  @SmokeTest @RegressionTest
  Scenario: An authenticated user can checkout an existing shopping cart when it contains items
    Given an authenticated user:
      | username | password | email                |
      | John     | D0E!     | john.doe@company.doe |
    When the user does a checkout of an existing shopping cart containing items
    Then the shopping cart is cleared
    And a checkout-event is published


