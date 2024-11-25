
Feature: ISO_SIMULATION
Scenario Outline: simulator-iso-validation
    Given Given <user> is on <url> page
    When When he enters the value <data> in the field identified by <elementId>
    And When he clicks the button identified by xpath <buttonXpath>
    Then Then he should be able to view <output> in the field
     Examples:     
          |  user  |  url  |  data  |  elementId  |  buttonXpath  |  output  |  
          |  john  |  http://localhost:8882/ISOMessage  |  hello  |  newDEinfo[0].DEValue  |  //button[@id='btnExecute']  |  Simulator  |  
