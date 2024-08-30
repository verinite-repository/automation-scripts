
Feature: ProductValidation
Scenario: ValidProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects T-Shirt from the list
    And User verify the product price is equal to the 10.00
Scenario: InvalidProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects T-Shirt from the list
    And User verify the product price is equal to the 10.00