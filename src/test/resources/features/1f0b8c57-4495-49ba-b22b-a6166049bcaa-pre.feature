
Feature: NewPowerCard
Scenario Outline: NewCard
    Given <user> is on <url> page
    When he enters the value <title> in the field named <search_input>
    And he clicks the button named <search_button>
    Then he should be able to view <title> in the field
     Examples:     
          |  user  |  url  |  title  |  search_input  |  search_button  |  title  |  
          |  John Doe  |  https://www.yahoo.com  |  IPhone 13  |  p  |  ybar-search  |  IPhone 13  |  
