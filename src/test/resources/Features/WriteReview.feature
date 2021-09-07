Feature: Write a review
  @WriteAReview
  Scenario: User is able to write a review
    Given user is logged in with email as "myaccount@test.com" and password as "Jen22"
    When user select product category as T shirts
    And Click on the product name
    And user click on write review and fill the form
    And user click on send button
    Then Success message should be appeared for new comment