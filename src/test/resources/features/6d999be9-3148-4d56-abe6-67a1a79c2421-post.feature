
Feature: ART_OF_TESTING_CHECKOUT
@Windows
Scenario Outline: VERIFY_LOGIN_ARTOFTESTING
    Given <user> is on <artoftesting> page
    When he clicks the button identified by xpath <ecom_artoftesting_loginbutton>
    Then he should be able to view <artOfTesting_Ecom> in the field
     Examples:     
          |  user  |  artoftesting  |  ecom_artoftesting_loginbutton  |  artOfTesting_Ecom  |  
          |  Smith  |  https://ecommerce.artoftesting.com/  |  //*[@id='root']/div/div[1]/div/div/div/div[1]/form/button  |  Dummy Ecommerce  |  

@web
Scenario Outline: VERIFY_SORTING_ARTOFTESTING
    Given <user> is on <artOfTesting_ecom> page
    When he clicks the button identified by xpath <ecom_artoftesting_loginbutton>
    And he clicks the button identified by xpath <sort_dropdown>
    And he clicks the button identified by xpath <sort_dropdown_option>
    Then he should be able to view <artOfTesting_Ecom> in the field
     Examples:     
          |  user  |  artOfTesting_ecom  |  ecom_artoftesting_loginbutton  |  sort_dropdown  |  sort_dropdown_option  |  artOfTesting_Ecom  |  
          |  Smith  |  https://ecommerce.artoftesting.com/  |  //*[@id='root']/div/div[1]/div/div/div/div[1]/form/button  |  //*[@id='root']/div/div[3]/div/div/select  |  //*[@id='root']/div/div[3]/div/div/select/option[2]  |  Dummy Ecommerce  |  

@web
Scenario Outline: VERIFY_ADDTOCART_ARTOFTESTING
    Given <user> is on <artoftesting> page
    When he clicks the button identified by xpath <ecom_artoftesting_loginbutton>
    And he clicks the button identified by xpath <add_to_cart>
    Then he should be able to view <artOfTesting_cart> in the field
     Examples:     
          |  user  |  artoftesting  |  ecom_artoftesting_loginbutton  |  add_to_cart  |  artOfTesting_cart  |  
          |  Smith  |  https://ecommerce.artoftesting.com/  |  //*[@id='root']/div/div[1]/div/div/div/div[1]/form/button  |  //*[@id='root']/div/div[4]/div/div[3]/div[4]/button  |  Dummy Ecommerce  |  

@web
Scenario Outline: ART_OF_TESTING_CHECKOUT
    Given <user> is on <artOfTesting_ecom> page
    When he clicks the button identified by xpath <ecom_artoftesting_loginbutton>
    And he clicks the button identified by xpath <sort_dropdown>
    And he clicks the button identified by xpath <sort_dropdown_option>
    And he clicks the button identified by xpath <AOT_ADD_TO_CART>
    And he clicks the button identified by xpath <AOT_ADD_TO_CART_BTN>
    Then he should be able to view <AOT_CART_PAGE_PRODUCT_TITLE> in the field
    And he clicks the button identified by xpath <AOT_CART_PAGE_CHECKOUT_BTN>
    And he should be able to view <AOT_PRODUCT_CHECKOUT_SUCCESS> in the field
     Examples:     
          |  user  |  artOfTesting_ecom  |  ecom_artoftesting_loginbutton  |  sort_dropdown  |  sort_dropdown_option  |  AOT_ADD_TO_CART  |  AOT_ADD_TO_CART_BTN  |  AOT_CART_PAGE_PRODUCT_TITLE  |  AOT_CART_PAGE_CHECKOUT_BTN  |  AOT_PRODUCT_CHECKOUT_SUCCESS  |  
          |  Smith  |  https://ecommerce.artoftesting.com/  |  //*[@id='root']/div/div[1]/div/div/div/div[1]/form/button  |  //*[@id='root']/div/div[3]/div/div/select  |  //*[@id='root']/div/div[3]/div/div/select/option[2]  |  //*[@id="root"]/div/div[4]/div/div[1]/div[4]/button  |  //*[@id="root"]/div/div[1]/div/div[2]/div  |  Dummy Ecommerce  |  //*[@id="root"]/div[5]/button  |  Dummy Ecommerce  |  
