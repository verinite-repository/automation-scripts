
Feature: AMZ_PRODUCT_CHECKOUT
Scenario Outline: AMZ_LOG_IN
    Given <user> is on <login_url_001> page
    When he enters the value <amazon_user_name_013> in the field with a path <login_box_002>
    And he clicks the button identified by xpath <continue_btn_003>
    And he enters the value <amazon_password_014> in the field with a path <password_box_004>
    And he clicks the button identified by xpath <sign_in_btn_005>
    Then he views the value in the field <after_log_in_015>
     Examples:     
          |  user  |  login_url_001  |  amazon_user_name_013  |  login_box_002  |  continue_btn_003  |  amazon_password_014  |  password_box_004  |  sign_in_btn_005  |  after_log_in_015  |  
          |  amazon_user  |  https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https3A2F2Fwww.amazon.in2Flog-in2Fs3Fk3Dlog2Bin26ref_3Dnav_ya_signin&openid.identity=http3A2F2Fspecs.openid.net2Fauth2F2.02Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http3A2F2Fspecs.openid.net2Fauth2F2.02Fidentifier_select&openid.ns=http3A2F2Fspecs.openid.net2Fauth2F2.0  |  +918483990166  |  //*[@id="ap_email_login"]  |  //*[@id="continue"]/span/input  |  Sachin@123  |  //*[@id="ap_password"]  |  //*[@id="signInSubmit"]  |  Amazon.in  |  
