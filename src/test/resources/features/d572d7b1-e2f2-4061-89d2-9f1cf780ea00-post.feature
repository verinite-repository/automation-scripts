
Feature: ProductValidation
Scenario Outline: VerifyProductValue
    Given User is on Login Screen
    When User enters username and password and clicks on login button
    Then User selects ${product.productName} from the list
    And User verify the product price is equal to the ${product.productPrice}
     Examples:     
          |  productName  |  productPrice  |  
          |  Apple iPhone 13 Pro  |  999.00  |  
