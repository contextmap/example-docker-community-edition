# language: en
@ShoppingCart @Epic-101
Feature: Add item to shopping cart
  A user can add an item from the inventory to a shopping cart via the REST API

  @SmokeTest @RegressionTest
  Scenario: An authenticated user adds an item to an existing shopping cart
    Given an authenticated user:
      | username | password | email                |
      | John     | D0E!     | john.doe@company.doe |
    When the user adds an inventory item to an existing shopping cart
    Then the inventory item is added to the shopping cart

  @RegressionTest
  Scenario: An authenticated user adds an item to a non-existing shopping cart
    Given an authenticated user:
      | username | password | email                |
      | John     | D0E!     | john.doe@company.doe |
    When the user adds an inventory item to a non-existing shopping cart
    Then the inventory item is not added to the shopping cart
    And a not found error is returned

  @RegressionTest
  Scenario: An non-authenticated user adds an item to an existing shopping cart
    Given an non-authenticated user:
    When the user adds an inventory item to an existing shopping cart
    Then the inventory item is not added to the shopping cart
    And a unauthorized error is returned

