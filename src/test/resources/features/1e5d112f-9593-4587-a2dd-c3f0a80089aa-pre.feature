
Feature: NEW_USER_A
Scenario Outline: ADACTIN_NEW_USER
    Given <user> is on <adactin> page
    When he clicks the button named <new_User_Register_Here>
    And he enters the value <username_name_value> in the field named <username_name_element>
    Then He should be able to view <adatin_register_page> in the field
     Examples:     
          |  user  |  adactin  |  new_User_Register_Here  |  username_name_value  |  username_name_element  |  adatin_register_page  |  
          |  John Doe  |  https://adactinhotelapp.com/index.php  |  New User Register Here  |  VeriniteCardtest  |  username  |  https://adactinhotelapp.com/Register.php  |  
