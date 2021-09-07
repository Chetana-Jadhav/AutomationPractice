Feature: Change in the image using colour feature
  @ChangeInImageColour
  Scenario: User is able to see change in image with colour feature
    Given user is logged in with email as "myaccount@test.com" and password as "Jen22"
    When user select product category as T shirts
    And Click on the product name
    And click on blue colour
    Then T-shirt colour in the image should be changed to blue
