# language: en
@ShoppingCart @Epic-100
Feature: Shopping cart creation
  A user can create a shopping cart via the REST API

  Background:
    When the Webshop site is opened in a browser

  @SmokeTest @RegressionTest
  Scenario: An authenticated user creates a shopping cart for the first time
    Given an authenticated user:
      | username | password | email                |
      | John     | D0E!     | john.doe@company.doe |
    When the user requests a new shopping cart
    Then the shopping cart should be created
    And the user should receive an email with:
    """
    Dear user,

    Your shopping cart was created.
    """

