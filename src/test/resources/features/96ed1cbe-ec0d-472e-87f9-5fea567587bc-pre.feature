
Feature: ProductValidation
Scenario: ValidProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects Fancy Widget from the list
    And User verify the product price is equal to the $19.99
Scenario: InvalidProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects Fancy Widget from the list
    And User verify the product price is equal to the $19.99