
Feature: ARTOFTESTING_ADDBOOKS
Scenario Outline: VERIFY_ADDTOCART_ARTOFTESTING
    Given <user> is on <artoftesting> page
    When he clicks the button identified by xpath <ecom_artoftesting_loginbutton>
    And he clicks the button identified by xpath <add_to_cart>
    Then he should be able to view <artOfTesting_cart> in the field
     Examples:     
          |  user  |  artoftesting  |  ecom_artoftesting_loginbutton  |  add_to_cart  |  artOfTesting_cart  |  
          |  John Doe  |  https://ecommerce.artoftesting.com/  |  //*[@id='root']/div/div[1]/div/div/div/div[1]/form/button  |  //*[@id='root']/div/div[4]/div/div[3]/div[4]/button  |  Dummy Ecommerce  |  
          |  John Doe  |  https://ecommerce.artoftesting.com/  |  //*[@id='root']/div/div[1]/div/div/div/div[1]/form/button  |  //*[@id='root']/div/div[4]/div/div[3]/div[4]/button  |  Dummy Ecommerce  |  
