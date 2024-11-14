
Feature: SauceLab
Scenario Outline: SauceLab
    Given <user> is on <sauce_lab_url> page
    When he enters the value <username_input> in the field identified by <username_tag>
    And he enters the value <password_input> in the field identified by <password_tag>
    And he clicks the button identified by <login_button>
    Then he should be able to view <data> in the field
     Examples:     
          |  user  |  sauce_lab_url  |  username_input  |  username_tag  |  password_input  |  password_tag  |  login_button  |  data  |  
          |  John  |  https://www.saucedemo.com/v1/index.html  |  standard_user  |  user-name  |  secret_sauce  |  password  |  login-button  |  Swag Labs  |  
