
Feature: SearchValidation
Scenario Outline: InputSearchValidation
    Given <user> is on <url> page
    When he enters the value <search_title> in the field named <search_input>
    And he clicks the button named <search_button>
    Then he should be able to view <search_title_result> in the field
     Examples:     
          |  user  |  url  |  search_title  |  search_input  |  search_button  |  search_title_result  |  
          |  John Doe  |  https://www.google.com  |  OpenAI  |  q  |  btnK  |  OpenAI  |  
