@captureimages
Feature: Capture Image when Test case fails

  Background:
    Given User is on the home page

    Scenario: User can able to Capture image when Test case fails
      When User selects SignIn link
      Then User should see the Login Page
      When User enter email  as "anugubjsstest@gmail.com" password as "BJSSTEST" and select Signin button
      Then User should see his name as "Anugu Reddy"
      When user selects home button
      Then User is on the home page
      When user selects my orders
      Then user should navigate to order history page
      When user select placed order
      Then user should see "Yellow" color blouse
      When user select signout link
      Then user should signout successfully
