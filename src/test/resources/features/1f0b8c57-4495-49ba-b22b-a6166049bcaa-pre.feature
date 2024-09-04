
Feature: NewPowerCard
Scenario Outline: NewCard
    Given <user> is on <google_url> page
    When he enters the value <serenity_title> in the field named <google_search_input>
    And he clicks the button named <google_search_button>
    Then he should be able to view <google_title> in the field
     Examples:     
          |  user  |  google_url  |  serenity_title  |  google_search_input  |  google_search_button  |  google_title  |  
          |  John Doe  |  https://www.google.com  |  Tech Lead  |  q  |  btnK  |  Software Engineer  |  
