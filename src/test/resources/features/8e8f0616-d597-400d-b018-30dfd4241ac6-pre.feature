
Feature: SauceLabsMarketPlace
Scenario Outline: NewCard
    Given <user> is on <google_url> page
    When he enters the value <serenity_title> in the field named <google_search_input>
    And he clicks the button named <google_search_button>
    Then he should be able to view <google_title> in the field
     Examples:     
          |  user  |  google_url  |  serenity_title  |  google_search_input  |  google_search_button  |  google_title  |  
          |  john.doe  |  https://www.google.com  |  Serenity BDD  |  q  |  btnK  |  Google Search  |  

Scenario Outline: SauceLab
    Given <user> is on <sauce_lab_url> page
    When he enters the value <username_input> in the field identified by <username_tag>
    And he enters the value <password_input> in the field identified by <password_tag>
    And he clicks the button identified by <login_button>
    Then he should be able to view <data> in the field
     Examples:     
          |  user  |  sauce_lab_url  |  username_input  |  username_tag  |  password_input  |  password_tag  |  login_button  |  data  |  
          |  jane.doe  |  https://www.saucedemo.com/v1/index.html  |  standard_user  |  user-name  |  secret_sauce  |  password  |  login-button  |  Swag Labs  |  
