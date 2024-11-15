
Feature: Simulator
Scenario Outline: Simulator
    Given <user> is on <url> page
    When he enters the value <data> in the field identified by <elementId>
    And he clicks the button identified by xpath <buttonXpath>
    Then Then he should be able to view <output> in the field
     Examples:     
          |  user  |  url  |  data  |  elementId  |  buttonXpath  |  output  |  
          |  John Doe  |  http://192.168.3.20:8882/ISOMessage  |  1234-5678-9876-5432  |  newDEinfo0.DEValue  |  //button[text()='Execute']  |  Simulator  |  
