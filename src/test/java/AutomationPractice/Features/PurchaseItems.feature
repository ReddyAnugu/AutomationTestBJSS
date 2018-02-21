
Feature:Happy path,Purchase 2 items
  As a user
  I want to select 2 items
  so that I can purchase items successfully

Background:
  Given User is on the home page

  @purchaseitem
  Scenario:User can able to purchase 2 items successfully
    When User selects SignIn link
    Then User should see the Login Page
    When User enter email  as "anugubjsstest@gmail.com" password as "BJSSTEST" and select Signin button
    Then User should see his name as "Anugu Reddy"
    When user selects home button
    Then User is on the home page
    When user Quick view Blouse product
    Then user should see Blouse product
    When user change the size of the item to "M"
    And add the item to the cart
    And continue shopping
    Then user should be on the home page
    When user Quick view Chiffon dress
    Then user should see Chiffon dress
    When user add the item to the cart
    And user proceed to checkout
    Then user should be on Shopping cart page
    And user should see M size Blouse
    And user should see S size Chiffon dress
    And user should see the correct price for Blouse
    And user should see the correct price for Chiffon dress
    And user should see sum of blouse and chiffon price as total products value
    And user should see sum of Total products and Shipping as Total
    When user selects summary proceed to checkout
    Then user should navigate to address page
    When user selects address proceed to checkout
    Then user should be on the shipping page
    When user selects terms of service checkbox
    And user selects shipping proceed to checkout
    Then user should see payment page
    When user selects pay by bank wire
    Then user should be on the bank wire payment page
    When user selects i confirm my order
    Then user should purchase products successfully
    When user select signout link after purchase
    Then User should see the Login Page
