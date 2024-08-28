
Feature: ProductValidation
Scenario: VerifyProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects The Old Man and the Sea from the list
    And User verify the product price is equal to the 12.99