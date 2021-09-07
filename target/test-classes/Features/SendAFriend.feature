Feature: Send product to a friend
  @Send_a_Friend
  Scenario: User is able to send product info to a friend
    Given user is logged in with email as "myaccount@test.com" and password as "Jen22"
    When user select product category as T shirts
    And Click on the product name
    And Click on Send to a Friend link, fill the details and click on Send
    Then Message should be appeared that Email sent in a pop up
