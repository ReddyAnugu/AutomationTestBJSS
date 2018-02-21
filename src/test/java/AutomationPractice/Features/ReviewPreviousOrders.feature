@revieworder
Feature:Review Previous Orders and add a message

  Background:
    Given User is on the home page

  Scenario: Review Previous Orders and add a message successfully
    When User selects SignIn link
    Then User should see the Login Page
    When User enter email  as "anugubjsstest@gmail.com" password as "BJSSTEST" and select Signin button
    Then User should see his name as "Anugu Reddy"
    When user selects home button
    Then User is on the home page
    When user selects my orders
    Then user should navigate to order history page
    When user select placed order
    Then user should see the date of order placed
    When user select product from previous order as "Blouse - Color : Black, Size : M"
    And user add comment about order
    And user submit comment
    Then comment should appear under messages
    When user select signout link
    Then user should signout successfully