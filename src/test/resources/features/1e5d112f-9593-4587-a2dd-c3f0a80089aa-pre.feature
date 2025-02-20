
Feature: NEW_USER_A
Scenario Outline: ADACTIN_NEW_USER
    Given <user> is on <adactin> page
    When he clicks the button identified by xpath <new_User_Register_Here>
    And he enters the value <username_name_value> in the field named <username_name_element>
    Then He should be able to view <adatin_register_page> in the field
     Examples:     
          |  user  |  adactin  |  new_User_Register_Here  |  username_name_value  |  username_name_element  |  adatin_register_page  |  
          |  John Doe  |  https://adactinhotelapp.com/index.php  |  //*[@id='login_form']/table/tbody/tr[7]/td/a  |  VeriniteCardtest  |  username  |  https://adactinhotelapp.com/Register.php  |  
