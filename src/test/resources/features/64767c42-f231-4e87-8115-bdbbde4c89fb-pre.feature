
Feature: ProductValidation
Scenario: ValidProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects Iphone 14 Pro Max from the list
    And User verify the product price is equal to the $1099
Scenario: InvalidProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects Iphone 14 Pro Max from the list
    And User verify the product price is equal to the $1099