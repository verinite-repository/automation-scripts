
Feature: Simulator
Scenario Outline: Simulator
    Given John is on <url> page
    When he enters the value <data> in the field identified by <elementId>
    And he clicks the button identified by xpath <buttonXpath>
    Then Then he should be able to view <output> in the field
     Examples:     
          |  url  |  data  |  elementId  |  buttonXpath  |  output  |  
          |  https://www.google.com  |  Swag Labs  |  newDEinfo0.DEValue  |  //button[text()='Execute']  |  Simulator  |  
