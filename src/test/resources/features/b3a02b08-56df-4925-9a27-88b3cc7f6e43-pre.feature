
Feature: Onboarding
Scenario: CreateCustomer
    Given John is on Add Customer page
    When He enters John Doe in the name field
    And He enters 123 Main Street in the address field
    And He clicks the Submit button
    Then The customer is created
Scenario: CreateAccount
    Given John is on Add Account page
    When He enters Monthly in the billing cycle field
    And He enters 1000.00 in the credit limit field
    And He clicks the Submit button
    Then The account is created
Scenario: CreateCard
    Given John is on Add Card page
    When He enters Visa in the cardtype field
    And He enters John Doe in the embossing name field
    And He clicks the Submit button
    Then The card is created
Feature: Onboarding
Scenario: CreateCustomer
    Given John is on Add Customer page
    When He enters John Doe in the name field
    And He enters 123 Main Street in the address field
    And He clicks the Submit button
    Then The customer is created
Scenario: CreateAccount
    Given John is on Add Account page
    When He enters Monthly in the billing cycle field
    And He enters 1000.00 in the credit limit field
    And He clicks the Submit button
    Then The account is created
Scenario: CreateCard
    Given John is on Add Card page
    When He enters Visa in the cardtype field
    And He enters John Doe in the embossing name field
    And He clicks the Submit button
    Then The card is created