
Feature: ProductValidation
Scenario: ValidProductValue
    GIVEN User is on Login Screen
    WHEN User enters username and password and clicks on login button
    THEN User selects Sauce Labs Backpack from the list
    AND User verify the product price is equal to the 29.99
Scenario: InvalidProductValue
    GIVEN User is on Login Screen
    WHEN User enters username and password and clicks on login button
    THEN User selects Sauce Labs Backpack from the list
    AND User verify the product price is equal to the 29.99