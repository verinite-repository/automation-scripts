
Feature: ProductValidation
Scenario: VerifyProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects Sneakers from the list
    And User verify the product price is equal to the $60.00