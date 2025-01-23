
Feature: CARD_ONBOARDING
Scenario Outline: CREATE_CARD
    Given <user> is on <createCard> page
    When He enters the value <productId> in the field identified by <productId>
    And He enters the value <accountID> in the field identified by <accountId>
    And He enters the value <embossingName> in the field identified by <embossingName>
    And He clicks the button identified by xpath <submit>
    Then He should be able to view <cardCreationSuccessMessage> in the field identified by <messageC>
     Examples:     
          |  user  |  createCard  |  productId  |  productId  |  accountID  |  accountId  |  embossingName  |  embossingName  |  submit  |  cardCreationSuccessMessage  |  messageC  |  
          |  Sam  |  http://localhost:8882/createCard  |  productIdentifier  |  accountIdentifier  |  embossingNameIdentifier  |  //button[@id='btnSubmit']  |  messageIdentidier  |  
